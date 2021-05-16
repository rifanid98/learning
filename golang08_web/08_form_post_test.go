package golang08_web

import (
	"fmt"
	"io"
	"net/http"
	"net/http/httptest"
	"strings"
	"testing"
)

// # Form Post
// - Saat kita belajar HTML, kita tahu bahwa saat kita membuat form,
// 	 kita bisa submit datanya dengan method GET atau POST
// - Jika menggunakan method GET, maka hasilnya semua data di form
// 	 akan menjadi query parameter
// - Sedangkan jika menggunakan POST, maka semua data di form akan
// 	 dikirim via body HTTP request
// - Di Go-Lang, untuk mengambil data Form Post sangatlah mudah

// # Request.PostForm
// - Semua data form post yang dikirim dari client, secara otomatis
// 	 akan disimpan dalam attribute Request.PostForm
// - Namun sebelum kita bisa mengambil data di attribute PostForm,
// 	 kita wajib memanggil method Request.ParseForm() terlebih dahulu,
// 	 method ini digunakan untuk melakukan parsing data body apakah bisa
// 	 di parsing menjadi form data atau tidak, jika tidak bisa di parsing,
// 	 maka akan menyebabkan error

func TestFormPost(t *testing.T) {
	handlerFunc := func(rw http.ResponseWriter, r *http.Request) {
		err := r.ParseForm()
		if err != nil {
			panic(err)
		}

		firstName := r.PostForm.Get("first_name")
		lastName := r.PostForm.Get("last_name")
		fmt.Fprintf(rw, "%s %s", firstName, lastName)
	}

	requestBody := strings.NewReader("first_name=Adnin&last_name=Rifandi")
	request := httptest.NewRequest(http.MethodPost, "http://localhost:8080", requestBody)
	request.Header.Add("Content-Type", "application/x-www-form-urlencoded")
	recorder := httptest.NewRecorder()

	handlerFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}
