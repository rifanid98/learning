package golang08_web

import (
	"fmt"
	"net/http"
	"testing"
)

// # Redirect
// - Saat kita membuat website, kadang kita butuh melakukan redirect
// - Misal setelah selesai login, kita lakukan redirect ke halaman dashboard
// - Redirect sendiri sebenarnya sudah standard di HTTP
// 	 https://developer.mozilla.org/en-US/docs/Web/HTTP/Redirections
// - Kita hanya perlu membuat response code 3xx dan menambah header Location
// - Namun untungnya di Go-Lang, ada function yang bisa kita gunakan untuk mempermudah
// 	 ini

func TestRedirect(t *testing.T) {
	handleFuncRedirectTo := func(rw http.ResponseWriter, r *http.Request) {
		fmt.Fprint(rw, "Hello Redirect")
	}

	handleFuncRedirectFrom := func(rw http.ResponseWriter, r *http.Request) {
		http.Redirect(rw, r, "/redirect-to", http.StatusTemporaryRedirect)
	}

	mux := http.NewServeMux()
	mux.HandleFunc("/redirect-from", handleFuncRedirectFrom)
	mux.HandleFunc("/redirect-to", handleFuncRedirectTo)

	server := http.Server{
		Addr:    "localhost:8080",
		Handler: mux,
	}

	err := server.ListenAndServe()
	if err != nil {
		panic(err)
	}
}
