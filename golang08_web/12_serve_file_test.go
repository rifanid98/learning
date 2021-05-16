package golang08_web

import (
	_ "embed"
	"fmt"
	"net/http"
	"testing"
)

// # ServeFile
// - Kadang ada kasus misal kita hanya ingin menggunakan static file
// 	 sesuai dengan yang kita inginkan
// - Hal ini bisa dilakukan menggunakan function http.ServeFile()
// - Dengan menggunakan function ini, kita bisa menentukan file mana
// 	 yang ingin kita tulis ke http response

func TestServeFile(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		if r.URL.Query().Get("name") != "" {
			http.ServeFile(rw, r, "./resources/200.html")
		} else {
			http.ServeFile(rw, r, "./resources/404.html")
		}
	}

	server := http.Server{
		Addr:    "localhost:8080",
		Handler: http.HandlerFunc(handleFunc),
	}

	err := server.ListenAndServe()
	if err != nil {
		panic(err)
	}
}

// # Go-Lang Embed
// - Parameter function http.ServeFile hanya berisi string file name,
// 	 sehingga tidak bisa menggunakan Go-Lang Embed
// - Namun bukan berarti kita tidak bisa menggunakan Go-Lang embed,
// 	 karena jika untuk melakukan load file, kita hanya butuh menggunakan
// 	 package fmt dan ResponseWriter saja

//go:embed resources/200.html
var resourceOk string

//go:embed resources/404.html
var resourceNotFound string

func TestServeFileGolangEmbed(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		if r.URL.Query().Get("name") != "" {
			fmt.Fprint(rw, resourceOk)
		} else {
			fmt.Fprint(rw, resourceNotFound)
		}
	}

	server := http.Server{
		Addr:    "localhost:8080",
		Handler: http.HandlerFunc(handleFunc),
	}

	err := server.ListenAndServe()
	if err != nil {
		panic(err)
	}
}
