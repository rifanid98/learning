package golang08_web

import (
	"fmt"
	"io"
	"net/http"
	"net/http/httptest"
	"testing"
	"text/template"
)

// # Template Data
// - Saat kita membuat template, kadang kita ingin menambahkan banyak data dinamis
// - Hal ini bisa kita lakukan dengan cara menggunakan data struct atau map
// - Namun perlu dilakukan perubahan di dalam text template nya, kita perlu memberi
// 	 tahu Field atau Key mana yang akan kita gunakan untuk mengisi data dinamis di
// 	 template
// - Kita bisa menyebutkan dengan cara seperti ini {{.NamaField}}

func TestTemplateDataMap(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.ParseFiles("./templates/templatedata.gohtml"))

		t.ExecuteTemplate(rw, "templatedata.gohtml", map[string]interface{}{
			"Title": "Template Data Map",
			"Name":  "Adnin Rifandi Sutanto Putra",
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}

func TestTemplateDataStruct(t *testing.T) {
	type Page struct {
		Title string
		Name  string
	}

	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.ParseFiles("./templates/templatedata.gohtml"))

		t.ExecuteTemplate(rw, "templatedata.gohtml", Page{
			Title: "Template Data Struct",
			Name:  "Adnin Rifandi Sutanto Putra",
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}

func TestTemplateDataNested(t *testing.T) {
	type Name struct {
		First string
		Last  string
	}

	type Page struct {
		Title string
		Name  Name
	}

	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.ParseFiles("./templates/templatedatanested.gohtml"))

		t.ExecuteTemplate(rw, "templatedatanested.gohtml", Page{
			Title: "Template Data Struct",
			Name: Name{
				First: "Adnin Rifandi",
				Last:  "Sutanto Putra",
			},
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}
