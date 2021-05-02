package golang06_database

import (
	"context"
	"fmt"
	"testing"
)

// # Auto Increment
// - Kadang kita membuat sebuah table dengan id auto increment
// - Dan kadang pula, kita ingin mengambil data id yang sudah kita insert
// 	 ke dalam MySQL
// - Sebenarnya kita bisa melakukan query ulang ke database menggunakan
// 	 SELECT LAST_INSERT_ID()
// - Tapi untungnya di Golang ada cara yang lebih mudah
// - Kita bisa menggunakan function (Result) LastInsertId() untuk mendapatkan
// 	 Id terakhir yang dibuat secara auto increment
// - Result adalah object yang dikembalikan ketika kita menggunakan function
// 	 Exec

func TestAutoIncrement(t *testing.T) {
	db := GetConnection()

	comment := "Adnin"

	ctx := context.Background()
	query := "INSERT INTO comments(comment) VALUES(?)"
	result, err := db.ExecContext(ctx, query, comment)

	if err != nil {
		panic(err)
	}

	insertId, err := result.LastInsertId()

	if err != nil {
		panic(err)
	}

	fmt.Println("Last insert id ", insertId)

	defer db.Close()
}
