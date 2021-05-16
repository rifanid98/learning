package golang08_web

import (
	"fmt"
	"io"
	"net/http"
	"net/http/httptest"
	"testing"
)

// # Header
// - Selain Query Parameter, dalam HTTP, ada juga yang bernama Header
// - Header adalah informasi tambahan yang biasa dikirim dari client
// 	 ke server atau sebaliknya
// - Jadi dalam Header, tidak hanya ada pada HTTP Request, pada HTTP
// 	 Response pun kita bisa menambahkan informasi header
// - Saat kita menggunakan browser, biasanya secara otomatis header
// 	 akan ditambahkan oleh browser, seperti informasi browser, jenis
// 	 tipe content yang dikirim dan diterima oleh browser, dan lain-lain

// # Request Header
// - Untuk menangkap request header yang dikirim oleh client, kita bisa
//   mengambilnya di Request.Header
// - Header mirip seperti Query Parameter, isinya adalah map[string][]string
// - Berbeda dengan Query Parameter yang case sensitive, secara
// 	 spesifikasi, Header key tidaklah case sensitive

func TestRequestHeader(t *testing.T) {
	handlerFunc := func(rw http.ResponseWriter, r *http.Request) {
		contentType := r.Header.Get("Content-Type")
		fmt.Fprint(rw, contentType)
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080/", nil)
	request.Header.Add("Content-Type", "application/json")
	recorder := httptest.NewRecorder()

	handlerFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}

// # Response Header
// - Sedangkan jika kita ingin menambahkan header pada response, kita
// 	 bisa menggunakan function ResponseWriter.Header()

func TestResponseHeader(t *testing.T) {
	handlerFunc := func(rw http.ResponseWriter, r *http.Request) {
		rw.Header().Add("X-Powered-By", "Adnin Rifandi")
		fmt.Fprint(rw, "OK")
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080/", nil)
	recorder := httptest.NewRecorder()

	handlerFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)
	poweredBy := recorder.Header().Get("X-Powered-By")

	fmt.Println(string(body))
	fmt.Println(poweredBy)
}
