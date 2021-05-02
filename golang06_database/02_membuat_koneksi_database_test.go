package golang06_database

import (
	"database/sql"
	"testing"

	_ "github.com/go-sql-driver/mysql"
)

// # Membuat Koneksi ke Database
// - Hal yang pertama akan kita lakukan ketika membuat aplikasi yang akan
// 	 menggunakan database adalah melakukan koneksi ke database nya
// - Untuk melakukan koneksi ke databsae di Golang, kita bisa membuat object
// 	 sql.DB menggunakan function sql.Open(driver, dataSourceName)
// - Untuk menggunakan database MySQL, kita bisa menggunakan driver “mysql”
// - Sedangkan untuk dataSourceName, tiap database biasanya punya cara
// 	 penulisan masing-masing, misal di MySQL, kita bisa menggunakan
// 	 dataSourceName seperti dibawah ini :
// - username:password@tcp(host:port)/database_name
// - Jika object sql.DB sudah tidak digunakan lagi, disarankan untuk
// 	 menutupnya menggunakan function Close()

func TestOpenConnection(t *testing.T) {
	db, err := sql.Open("mysql", "root:root@tcp(localhost:3307)/golang")

	if err != nil {
		panic(err)
	}

	defer db.Close()
}
