package golang08_web

import (
	"fmt"
	"io"
	"net/http"
	"net/http/httptest"
	"strings"
	"testing"
	"text/template"
)

// # Template Function
// - Selain mengakses field, dalam template, function juga bisa diakses
// - Cara mengakses function sama seperti mengakses field, namun jika function
// 	 tersebut memiliki parameter, kita bisa gunakan tambahkan parameter ketika memanggil
// 	 function di template nya
// - {{.FunctionName}}, memanggil field FunctionName atau function FunctionName()
// - {{.FunctionName “eko”, “kurniawan”}}, memanggil function FunctionName(“eko”, “kurniawan”)

type MyPage struct {
	Name string
}

func (myPage MyPage) SayHello(name string) string {
	return "Hello " + name + ", My name is " + myPage.Name
}

func TestTemplateFunction(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.New("FUNCTION").Parse(`{{ .SayHello "Budi" }}`))
		t.ExecuteTemplate(rw, "FUNCTION", MyPage{
			Name: "Adnin Rifandi",
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}

// # Global Function
// - Go-Lang template memiliki beberapa global function
// - Global function adalah function yang bisa digunakan secara langsung, tanpa menggunakan
// 	 template data
// - Berikut adalah beberapa global function di Go-Lang template
// - https://github.com/golang/go/blob/master/src/text/template/funcs.go

func TestTemplateGlobalFunction(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.New("FUNCTION").Parse(`{{ len .Name }}`))
		t.ExecuteTemplate(rw, "FUNCTION", map[string]interface{}{
			"Name": "Adnin Rifandi",
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}

// # Menambah Global Function
// - Kita juga bisa menambah global function
// - Untuk menambah global function, kita bisa menggunakan method Funcs pada template
// - Perlu diingat, bahwa menambahkan global function harus dilakukan sebelum melakukan
// 	 parsing template

func TestTemplateAddGlobalFunction(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.New("FUNCTION")
		t = t.Funcs(map[string]interface{}{
			"upper": func(value string) string {
				return strings.ToUpper(value)
			},
		})
		t = template.Must(t.Parse(`{{upper .Name}}`))

		t.ExecuteTemplate(rw, "FUNCTION", map[string]interface{}{
			"Name": "Adnin Rifandi",
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}

// # Function Pipelines
// - Go-Lang template mendukung function pipelines, artinya hasil dari function bisa
// 	 dikirim ke function berikutnya
// - Untuk menggunakan function pipelines, kita bisa menggunakan tanda | , misal :
// - {{ sayHello .Name | upper }}, artinya akan memanggil global function sayHello(Name)
// 	 hasil dari sayHello(Name) akan dikirim ke function upper(hasil)
// - Kita bisa menambahkan function pipelines lebih dari satu

func TestTemplateFunctionPipelines(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.New("FUNCTION")
		t = t.Funcs(map[string]interface{}{
			"sayHello": func(value string) string {
				return "Hello " + value
			},
			"upper": func(value string) string {
				return strings.ToUpper(value)
			},
			"finally": func(value string) string {
				return value + " finally"
			},
		})
		t = template.Must(t.Parse(`{{sayHello .Name | upper | finally}}`))

		t.ExecuteTemplate(rw, "FUNCTION", map[string]interface{}{
			"Name": "Adnin Rifandi",
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}
