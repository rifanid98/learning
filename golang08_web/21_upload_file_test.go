package golang08_web

import (
	"io"
	"net/http"
	"os"
	"testing"
	"text/template"
)

// # Upload File
// - Saat membuat web, selain menerima input data berupa form dan query param,
// 	 kadang kita juga menerima input data berupa file dari client
// - Go-Lang Web sudah memiliki fitur untuk management upload file
// - Hal ini memudahkan kita ketika butuh membuat web yang menerima input file
// 	 upload

// # Multipart
// - Saat kita ingin menerima upload file, kita perlu melakukan parsing terlebih
// 	 dahulu menggunakan Request.ParseMultipartForm(size), atau kita bisa langsung
// 	 ambil data file nya menggunakan Request.FormFile(name), di dalam nya secara
// 	 otomatis melakukan parsing terlebih dahulu
// - Hasilnya merupakan data-data yang terdapat pada package multipart, seperti
// 	 multipart.File sebagai representasi file nya, dan multipart.FileHeader sebagai
// 	 informasi file nya

var myTemplates2 = template.Must(template.ParseFS(embedTemplates, "templates/*.gohtml"))

func TestUploadFile(t *testing.T) {
	uploadForm := func(rw http.ResponseWriter, r *http.Request) {
		err := myTemplates2.ExecuteTemplate(rw, "upload.form.gohtml", nil)
		if err != nil {
			panic(err)
		}
	}

	uploadProcess := func(rw http.ResponseWriter, r *http.Request) {
		// r.ParseMultipartForm(32 << 20)
		file, fileHeader, err := r.FormFile("file")
		if err != nil {
			panic(err)
		}
		fileDestination, err := os.Create("./resources/" + fileHeader.Filename)
		if err != nil {
			panic(err)
		}
		_, err = io.Copy(fileDestination, file)
		if err != nil {
			panic(err)
		}
		name := r.PostFormValue("name")
		myTemplates2.ExecuteTemplate(rw, "upload.success.gohtml", map[string]interface{}{
			"Name": name,
			"File": "/static/" + fileHeader.Filename,
		})
	}

	mux := http.NewServeMux()
	mux.HandleFunc("/", func(rw http.ResponseWriter, r *http.Request) {
		http.Redirect(rw, r, "/form", http.StatusPermanentRedirect)
	})
	mux.HandleFunc("/form", uploadForm)
	mux.HandleFunc("/upload", uploadProcess)
	mux.Handle("/static/", http.StripPrefix("/static", http.FileServer(http.Dir("./resources"))))

	server := http.Server{
		Addr:    "localhost:8080",
		Handler: mux,
	}

	err := server.ListenAndServe()
	if err != nil {
		panic(err)
	}
}
