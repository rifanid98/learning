package golang08_web

import (
	"embed"
	"fmt"
	"io"
	"net/http"
	"net/http/httptest"
	"testing"
	"text/template"
)

// # Template Caching
// - Kode-kode diatas yang sudah kita praktekan sebenarnya tidak efisien
// - Hal ini dikarenakan, setiap Handler dipanggil, kita selalu melakukan parsing ulang
// 	 template nya
// - Idealnya template hanya melakukan parsing satu kali diawal ketika aplikasinya berjalan
// - Selanjutnya data template akan di caching (disimpan di memory), sehingga kita tidak
// 	 perlu melakukan parsing lagi
// - Hal ini akan membuat web kita semakin cepat

//go:embed templates/*.gohtml
var embedTemplates embed.FS

var myTemplates = template.Must(template.ParseFS(embedTemplates, "templates/*.gohtml"))

func TestTemplateCaching(t *testing.T) {
	handleFunc := func(rw http.ResponseWriter, r *http.Request) {
		myTemplates.ExecuteTemplate(rw, "simple.gohtml", "Hello HTML Template")
	}

	request := httptest.NewRequest(http.MethodGet, "http://localhost:8080", nil)
	recorder := httptest.NewRecorder()

	handleFunc(recorder, request)

	response := recorder.Result()
	body, _ := io.ReadAll(response.Body)

	fmt.Println(string(body))
}
