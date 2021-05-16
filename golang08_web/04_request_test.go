package golang08_web

import (
	"fmt"
	"net/http"
	"testing"
)

// # Request
// - Request adalah struct yang merepresentasikan HTTP Request yang
// 	 dikirim oleh Web Browser
// - Semua informasi request yang dikirim bisa kita dapatkan di Request
// - Seperti, URL, http method, http header, http body, dan lain-lain

func TestRequest(t *testing.T) {
	handler := http.HandlerFunc(func(rw http.ResponseWriter, r *http.Request) {
		fmt.Fprintln(rw, r.Method)
		fmt.Fprintln(rw, r.RequestURI)
	})

	server := http.Server{
		Addr:    "localhost:8080",
		Handler: handler,
	}

	err := server.ListenAndServe()
	if err != nil {
		panic(err)
	}
}
