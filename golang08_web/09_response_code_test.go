package golang08_web

import (
	"fmt"
	"io"
	"net/http"
	"net/http/httptest"
	"testing"
)

// # Response Code
// - Dalam HTTP, terdapat yang namanya response code
// - Response code merupakan representasi kode response
// - Dari response code ini kita bisa melihat apakah sebuah request
// 	 yang kita kirim itu sukses diproses oleh server atau gagal
// - Ada banyak sekali response code yang bisa kita gunakan saat
// 	 membuat web
// - https://developer.mozilla.org/en-US/docs/Web/HTTP/Status

// # Mengubah Response Code
// - Secara default, jika kita tidak menyebutkan response code, maka
// 	 response code nya adalah 200 OK
// - Jika kita ingin mengubahnya, kita bisa menggunakan function
// 	 ResponseWriter.WriteHeader(int)
// - Semua data status code juga sudah disediakan di Go-Lang, jadi kita
// 	 ingin, kita bisa gunakan variable yang sudah disediakan :
// 	 https://github.com/golang/go/blob/master/src/net/http/status.go

func TestResponseCode(t *testing.T) {
	handlerFunc := func(rw http.ResponseWriter, r *http.Request) {
		name := r.URL.Query().Get("name")
		if name == "" {
			rw.WriteHeader(http.StatusBadRequest)
			fmt.Fprint(rw, "name is empty")
		} else {
			fmt.Fprintf(rw, "Hi %s", name)
		}
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080/hello?name=Adnin", nil)
	recorder := httptest.NewRecorder()

	handlerFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}
