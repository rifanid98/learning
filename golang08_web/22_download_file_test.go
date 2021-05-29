package golang08_web

import (
	"fmt"
	"net/http"
	"testing"
)

// # Download File
// - Selain upload file, kadang kita ingin membuat halaman website yang digunakan untuk
// 	 download sesuatu
// - Sebenarnya di Go-Lang sudah disediakan menggunakan FileServer dan ServeFile
// - Dan jika kita ingin memaksa file di download (tanpa di render oleh browser, kita
// 	 bisa menggunakan header Content-Disposition)
// - https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Disposition

func TestDownloadFile(t *testing.T) {
	handlerFunc := func(rw http.ResponseWriter, r *http.Request) {
		fileName := r.URL.Query().Get("file")
		if fileName == "" {
			rw.WriteHeader(http.StatusBadRequest)
			fmt.Fprint(rw, "BAD REQUEST")
			return
		}

		rw.Header().Add("Content-Disposition", "attachment; filename=\""+fileName+"\"")
		http.ServeFile(rw, r, "./resources/"+fileName)
	}

	server := http.Server{
		Addr:    "localhost:8080",
		Handler: http.HandlerFunc(handlerFunc),
	}

	err := server.ListenAndServe()
	if err != nil {
		panic(err)
	}
}
