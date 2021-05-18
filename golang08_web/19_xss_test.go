package golang08_web

import (
	"fmt"
	"html/template"
	"io"
	"net/http"
	"net/http/httptest"
	"testing"
)

// # XSS (Cross Site Scripting)
// - XSS adalah salah satu security issue yang biasa terjadi ketika membuat web
// - XSS adalah celah keamanan, dimana orang bisa secara sengaja memasukkan
// 	 parameter yang mengandung JavaScript agar dirender oleh halaman website kita
// - Biasanya tujuan dari XSS adalah mencuri cookie browser pengguna yang sedang
// 	 mengakses website kita
// - XSS bisa menyebabkan account pengguna kita diambil alih jika tidak ditangani
// 	 dengan baik

// # Auto Escape
// - Berbeda dengan bahasa pemrograman lain seperti PHP, pada Go-Lang template,
// 	 masalah XSS sudah diatasi secara otomatis
// - Go-Lang template memiliki fitur Auto Escape, dimana dia bisa mendeteksi data
//   yang perlu ditampilkan di template, jika mengandung tag-tag html atau script,
// 	 secara otomatis akan di escape
// - Semua function escape bisa diliat disini :
// - https://github.com/golang/go/blob/master/src/html/template/escape.go
// - https://golang.org/pkg/html/template/#hdr-Contexts

func TestXSSAutoEscampe(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.ParseFiles("./templates/xss.gohtml"))
		t.ExecuteTemplate(rw, "xss.gohtml", map[string]interface{}{
			"Title": "Go-Lang Auto Escape",
			"Body":  "<p>Selamat Belajar Go-Lang Web</p>",
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}

// Mematikan Auto Escape
// - Jika kita mau, auto escape juga bisa kita matikan
// - Namun, kita perlu memberi tahu template secara eksplisit ketika kita menambahkan
// 	 template data
// - Kita bisa menggunakan data
// - template.HTML , jika ini adalah data html
// - template.CSS, jika ini adalah data css
// - template.JS, jika ini adalah data javascript

func TestXSSAutoEscapeOff(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.ParseFiles("./templates/xss.gohtml"))
		t.ExecuteTemplate(rw, "xss.gohtml", map[string]interface{}{
			"Title": "Go-Lang Auto Escape",
			"Body":  template.HTML("<p>Selamat Belajar Go-Lang Web</p>"),
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}
