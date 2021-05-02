package golang06_database

import (
	"context"
	"fmt"
	"testing"
)

// # SQL Dengan Parameter
// - Saat membuat aplikasi, kita tidak mungkin akan melakukan hardcode
// 	 perintah SQL di kode Golang kita
// - Biasanya kita akan menerima input data dari user, lalu membuat
// 	 perintah SQL dari input user, dan mengirimnya menggunakan perintah
// 	 SQL

// # SQL Injection
// - SQL Injection adalah sebuah teknik yang menyalahgunakan sebuah celah
// 	 keamanan yang terjadi dalam lapisan basis data sebuah aplikasi.
// - Biasa, SQL Injection dilakukan dengan mengirim input dari user dengan
// 	 perintah yang salah, sehingga menyebabkan hasil SQL yang kita buat
// 	 menjadi tidak valid
// - SQL Injection sangat berbahaya, jika sampai kita salah membuat SQL,
// 	 bisa jadi data kita tidak aman

func TestSQLInjection(t *testing.T) {
	db := GetConnection()
	id := "adnin'; #"
	name := "Adnin"

	ctx := context.Background()
	query := "SELECT id, name FROM customer WHERE id = '" + id + "' and name = '" + name + "'"
	rows, err := db.QueryContext(ctx, query)

	if err != nil {
		panic(err)
	}

	for rows.Next() {
		var id, name string
		err := rows.Scan(&id, &name)
		if err != nil {
			panic(err)
		}
		fmt.Println("id \t: ", id)
		fmt.Println("name \t: ", name)

		fmt.Println("-------------------------------------------")
	}
}

// # Solusinya?
// - Jangan membuat query SQL secara manual dengan menggabungkan String
// 	 secara bulat-bulat
// - Jika kita membutuhkan parameter ketika membuat SQL, kita bisa
// 	 menggunakan function Execute atau Query dengan parameter yang akan
// 	 kita bahas di chapter selanjutnya
