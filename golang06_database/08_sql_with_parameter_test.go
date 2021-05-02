package golang06_database

import (
	"context"
	"fmt"
	"testing"
)

// # SQL Dengan Paramaeter
// - Sekarang kita sudah tahu bahaya nya SQL Injection jika menggabungkan
// 	 string ketika membuat query
// - Jika ada kebutuhan seperti itu, sebenarnya function Exec dan Query
// 	 memiliki parameter tambahan yang bisa kita gunakan untuk mensubtitusi
// 	 parameter dari function tersebut ke SQL query yang kita buat.
// - Untuk menandai sebuah SQL membutuhkan parameter, kita bisa gunakan
// 	 karakter ? (tanda tanya)

// # Contoh SQL
// - SELECT username FROM user WHERE username = ? AND password = ? LIMIT 1
// - INSERT INTO user(username, password) VALUES (?, ?)
// - Dan lain-lain

func TestSQLWithParameter(t *testing.T) {
	db := GetConnection()

	id := "adnin"
	name := "Adnin"

	ctx := context.Background()
	query := "SELECT id, name FROM customer WHERE id = ? and name = ?"
	rows, err := db.QueryContext(ctx, query, id, name)
	// ini juga berlaku untuk ExecContext dan lainnya

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

	defer db.Close()
}
