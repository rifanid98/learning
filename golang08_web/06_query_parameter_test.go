package golang08_web

import (
	"fmt"
	"io"
	"net/http"
	"net/http/httptest"
	"net/url"
	"strings"
	"testing"
)

// # Query Parameter
// - Query parameter adalah salah satu fitur yang biasa kita gunakan
// 	 ketika membuat web
// - Query parameter biasanya digunakan untuk mengirim data dari client
// 	 ke server
// - Query parameter ditempatkan pada URL
// - Untuk menambahkan query parameter, kita bisa menggunakan
// 	 ?nama=value pada URL nya

// # url.URL
// - Dalam parameter Request, terdapat attribute URL yang berisi data
// 	 url.URL
// - Dari data URL ini, kita bisa mengambil data query parameter yang
// 	 dikirim dari client dengan menggunakan method Query() yang akan
// 	 mengembalikan map

func TestQueryParameter(t *testing.T) {
	handlerFunc := func(rw http.ResponseWriter, r *http.Request) {
		name := r.URL.Query().Get("name")
		if name == "" {
			fmt.Fprint(rw, "Hello")
		} else {
			fmt.Fprintf(rw, "Hello %s", name)
		}
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080/hello?name=Adnin", nil)
	recorder := httptest.NewRecorder()

	handlerFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}

// # Multiple Query Parameter
// - Dalam spesifikasi URL, kita bisa menambahkan lebih dari satu query
// 	 parameter
// - Ini cocok sekali jika kita memang ingin mengirim banyak data ke
// 	 server, cukup tambahkan query parameter lainnya
// - Untuk menambahkan query parameter, kita bisa gunakan tanda & lalu
// 	 diikuti dengan query parameter berikutnya

func TestMultipleQueryParameter(t *testing.T) {
	handlerFunc := func(rw http.ResponseWriter, r *http.Request) {
		firstName := r.URL.Query().Get("first_name")
		lastName := r.URL.Query().Get("last_name")
		fmt.Fprintf(rw, "Hello %s %s", firstName, lastName)
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080/hello?first_name=Adnin&last_name=Rifandi", nil)
	recorder := httptest.NewRecorder()

	handlerFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}

// # Multiple Value Query Parameter
// - Sebenarnya URL melakukan parsing query parameter dan menyimpannya
// 	 dalam map[string][]string
// - Artinya, dalam satu key query parameter, kita bisa memasukkan
// 	 beberapa value
// - Caranya kita bisa menambahkan query parameter dengan nama yang sama,
// 	 namun value berbeda, misal :
// - name=Eko&name=Kurniawan

func TestMultipleValueQueryParameter(t *testing.T) {
	handlerFunc := func(rw http.ResponseWriter, r *http.Request) {
		var query url.Values = r.URL.Query()
		var names []string = query["name"]
		fmt.Fprint(rw, strings.Join(names, ", "))
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080/hello?name=Adnin&name=Rifandi", nil)
	recorder := httptest.NewRecorder()

	handlerFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))

}
