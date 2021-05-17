package golang08_web

import (
	"fmt"
	"io"
	"net/http"
	"net/http/httptest"
	"testing"
	"text/template"
)

// # Template Action
// - Go-Lang template mendukung perintah action, seperti percabangan, perulangan
// 	 dan lain-lain

// # If Else
// - {{if .Value}} T1 {{end}}, jika Value tidak kosong, maka T1 akan dieksekusi,
// 	 jika kosong, tidak ada yang dieksekusi
// - {{if .Value}} T1 {{else}} T2 {{end}}, jika value tidak kosong, maka T1 akan
// 	 ieksekusi, jika kosong, T2 yang akan dieksekusi
// - {{if .Value1}} T1 {{else if .Value2}} T2 {{else}} T3 {{end}}, jika Value1
// 	 idak kosong, maka T1 akan dieksekusi, jika Value2 tidak kosong, maka T2 akan dieksekusi, jika tidak semuanya, maka T3 akan dieksekusi

func TestTemplateActionIf(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.ParseFiles("./templates/templateaction.gohtml"))

		t.ExecuteTemplate(rw, "templateaction.gohtml", map[string]interface{}{
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

// # Operator Perbandingan
// - Go-Lang template juga mendukung operator perbandingan, ini cocok ketika butuh
// 	 melakukan perbandingan number di if statement, berikut adalah operator nya :
// 	 > eq	artinya arg1 == arg2
// 	 > ne	artinya arg1 != arg2
// 	 > lt	artinya arg1 < arg2
// 	 > le	artinya arg1 <= arg2
// 	 > gt	artinya arg1 > arg2
// 	 > ge	artinya arg1 >= arg2

func TestTemplateActionOperator(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.ParseFiles("./templates/templateactionoperatorperbandingan.gohtml"))

		t.ExecuteTemplate(rw, "templateactionoperatorperbandingan.gohtml", map[string]interface{}{
			"FinalValue": 50,
		})
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}

// # Range
// - Range digunakan untuk melakukan iterasi data template
// - Tidak ada perulangan biasa seperti menggunakan for di Go-Lang template
// - Yang kita bisa lakukan adalah menggunakan range untuk mengiterasi tiap data array, slice,
// 	  map atau channel
// - {{range $index, $element := .Value}} T1 {{end}}, jika value memiliki data, maka T1 akan
// 	 dieksekusi sebanyak element value, dan kita bisa menggunakan $index untuk mengakses index
// 	 dan $element untuk mengakses element
// - {{range $index, $element := .Value}} T1 {{else}} T2 {{end}}, sama seperti sebelumnya,
// 	 namun jika value tidak memiliki element apapun, maka T2 yang akan dieksekusi

func TestTemplateActionRange(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.ParseFiles("./templates/templateactionrange.gohtml"))

		t.ExecuteTemplate(rw, "templateactionrange.gohtml", map[string]interface{}{
			"Hobbies": []string{
				"Learning", "Coding", "Gaming",
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

// # With
// - Kadang kita sering membuat nested struct
// - Jika menggunakan template, kita bisa mengaksesnya menggunakan .Value.NestedValue
// - Di template terdapat action with, yang bisa digunakan mengubah scope dot menjadi object
// 	 yang kita mau
// - {{with .Value}} T1 {{end}}, jika value tidak kosong, di T1 semua dot akan merefer ke value
// - {{with .Value}} T1 {{else}} T2 {{end}}, sama seperti sebelumnya, namun jika value kosong,
// 	 maka T2 yang akan dieksekusi

func TestTemplateActionWith(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		t := template.Must(template.ParseFiles("./templates/templateactionwith.gohtml"))

		t.ExecuteTemplate(rw, "templateactionwith.gohtml", map[string]interface{}{
			"Name": "Adnin Rifandi",
			"Address": map[string]interface{}{
				"Street": "Jalan Cinangneng",
				"City":   "Bogor",
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

// # Comment
// - Template juga mendukung komentar
// - Komentar secara otomatis akan hilang ketika template text di parsing
// - Untuk membuat komentar sangat sederhana, kita bisa gunakan
// 	 {{/* Contoh Komentar */}}
