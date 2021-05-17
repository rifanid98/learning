package golang08_web

import (
	"fmt"
	"io"
	"net/http"
	"net/http/httptest"
	"testing"
	"text/template"
)

// # Template Layout
// - Saat kita membuat halaman website, kadang ada beberapa bagian
// 	 yang selalu sama, misal header dan footer
// - Best practice nya jika terdapat bagian yang selalu sama, disarankan
// 	 untuk disimpan pada template yang terpisah, agar bisa digunakan di
// 	 template lain
// - Go-Lang template mendukung import dari template lain

// # Import Template
// - Untuk melakukan import, kita bisa menggunakan perintah berikut :
// - {{template “nama”}}, artinya kita akan meng-import template “nama”
// 	 tanpa memberikan data apapun
// - {{template “nama” .Value}}, artinya kita akan meng-import template
// 	 “nama” dengan memberikann data value

func TestTemplateLayout(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.ParseFiles(
			"./templates/layout/templateheader.gohtml",
			"./templates/layout/templatebody.gohtml",
			"./templates/layout/templatefooter.gohtml",
		))

		t.ExecuteTemplate(rw, "templatebody.gohtml", map[string]interface{}{
			"Name":  "Adnin Rifandi",
			"Title": "Template Layout",
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}

// # Template Name
// - Saat kita membuat template dari file, secara otomatis nama file
// 	 nya akan menjadi nama template
// - Namun jika kita ingin mengubah nama template nya, kita juga bisa
// 	 melakukan mengguakan perintah {{define “nama”}} TEMPLATE {{end}},
// 	 artinya kita membuat template dengan nama “nama”

func TestTemplateLayoutNamed(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.ParseFiles(
			"./templates/layout/templateheader.gohtml",
			"./templates/layout/templatebodynamed.gohtml",
			"./templates/layout/templatefooter.gohtml",
		))

		// "layout" is named layout template as {{define "layout"}}
		t.ExecuteTemplate(rw, "layout", map[string]interface{}{
			"Name":  "Adnin Rifandi",
			"Title": "Template Layout",
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}
