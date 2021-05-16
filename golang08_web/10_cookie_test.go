package golang08_web

import (
	"fmt"
	"net/http"
	"testing"
)

// # Stateless
// - HTTP merupakan stateless antara client dan server, artinya server
//   tidak akan menyimpan data apapun untuk mengingat setiap request dari
// 	 client
// - Hal ini bertujuan agar mudah melakukan scalability di sisi server
// - Lantas bagaimana caranya agar server bisa mengingat sebuah client?
//   Misal ketika kita sudah login di website, server otomatis harus tahu
// 	 jika client tersebut sudah login, sehingga request selanjutnya,
// 	 tidak perlu diminta untuk login lagi
// - Untuk melakukan hal ini, kita bisa memanfaatkan Cookie

// # Cookie
// - Cookie adalah fitur di HTTP dimana server bisa memberi response
// 	 cookie (key-value) dan client akan menyimpan cookie tersebut di
// 	 web browser
// - Request selanjutnya, client akan selalu membawa cookie tersebut
// 	 secara otomatis
// - Dan server secara otomatis akan selalu menerima data cookie yang
// 	 dibawa oleh client setiap kalo client mengirimkan request

// # Membuat Cookie
// - Cookie merupakan data yang dibuat di server dan sengaja agar
// 	 disimpan di web browser
// - Untuk membuat cookie di server, kita bisa menggunakan function
// 	 http.SetCookie()

func TestCookie(t *testing.T) {
	handlerFuncSetCookie := func(rw http.ResponseWriter, r *http.Request) {
		cookie := new(http.Cookie)
		cookie.Name = "X-PZN-Name"
		cookie.Value = r.URL.Query().Get("name")
		cookie.Path = "/"

		http.SetCookie(rw, cookie)
		fmt.Fprint(rw, "")
	}

	handlerFuncGetCookie := func(rw http.ResponseWriter, r *http.Request) {
		cookie, err := r.Cookie("X-PZN-Name")
		if err != nil {
			fmt.Fprint(rw, "No Cookie")
		} else {
			fmt.Fprintf(rw, "Hello %s", cookie.Value)
		}
	}

	mux := http.NewServeMux()
	mux.HandleFunc("/set-cookie", handlerFuncSetCookie)
	mux.HandleFunc("/get-cookie", handlerFuncGetCookie)

	server := http.Server{
		Addr:    "localhost:8080",
		Handler: mux,
	}

	err := server.ListenAndServe()
	if err != nil {
		panic(err)
	}
}
