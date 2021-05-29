package golang08_web

import (
	"fmt"
	"net/http"
	"testing"
)

// # Middleware
// - Dalam pembuatan web, ada konsep yang bernama middleware atau filter atau interceptor
// - Middleware adalah sebuah fitur dimana kita bisa menambahkan kode sebelum dan setelah
// 	 sebuah handler di eksekusi

// # Middleware di Go-Lang Web
// - Sayangnya, di Go-Lang web tidak ada middleware
// - Namun karena struktur handler yang baik menggunakan interface, kita bisa membuat
// 	 middleware sendiri menggunakan handler

type LogMiddleware struct {
	Handler http.Handler
}

func (middleware *LogMiddleware) ServeHTTP(rw http.ResponseWriter, r *http.Request) {
	fmt.Println("Before execute Handler")
	middleware.Handler.ServeHTTP(rw, r)
	fmt.Println("After execute Handler")
}

func TestMiddleware(t *testing.T) {
	mux := http.NewServeMux()
	mux.HandleFunc("/", func(rw http.ResponseWriter, r *http.Request) {
		fmt.Println("Handler executed")
		fmt.Fprint(rw, "Hello Middleware")
	})

	// # Cara 1
	logMiddleware := &LogMiddleware{
		Handler: mux,
	}

	// # Cara 2
	// logMiddleware := new(LogMiddleware)
	// logMiddleware.Handler = mux

	server := http.Server{
		Addr:    "localhost:8080",
		Handler: logMiddleware,
	}

	err := server.ListenAndServe()
	if err != nil {
		panic(err)
	}
}

// # Error Handler
// - Kadang middleware juga biasa digunakan untuk melakukan error handler
// - Hal ini sehingga jika terjadi panic di Handler, kita bisa melakukan recover di middleware,
// 	 dan mengubah panic tersebut menjadi error response
// - Dengan ini, kita bisa menjaga aplikasi kita tidak berhenti berjalan

type ErrorHandler struct {
	Handler http.Handler
}

func (handler *ErrorHandler) ServeHTTP(rw http.ResponseWriter, r *http.Request) {
	defer func() {
		err := recover()
		fmt.Println("RECOVER : ", err)
		if err != nil {
			rw.WriteHeader(http.StatusInternalServerError)
			fmt.Fprintf(rw, "Error : %s", err)
		}
	}()
	handler.Handler.ServeHTTP(rw, r)
}

func TestErrorHandler(t *testing.T) {
	mux := http.NewServeMux()
	mux.HandleFunc("/", func(rw http.ResponseWriter, r *http.Request) {
		panic("Ups, Error Happens")
	})

	errorHandler := &ErrorHandler{
		Handler: mux,
	}

	server := http.Server{
		Addr:    "localhost:8080",
		Handler: errorHandler,
	}

	err := server.ListenAndServe()
	if err != nil {
		panic(err)
	}
}
