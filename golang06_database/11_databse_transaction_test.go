package golang06_database

import (
	"context"
	"fmt"
	"strconv"
	"testing"
)

// # Database Transaction
// - Salah satu fitur andalan di database adalah transaction
// - Materi database transaction sudah saya bahas dengan tuntas
// 	 di materi MySQL database, jadi silahkan pelajari di course tersebut
// - Di course ini kita akan fokus bagaimana menggunakan database transaction
// 	 di Golang

// # Transaction di Golang
// - Secara default, semua perintah SQL yang kita kirim menggunakan Golang
// 	 akan otomatis di commit, atau istilahnya auto commit
// - Namun kita bisa menggunakan fitur transaksi sehingga SQL yang kita
// 	 kirim tidak secara otomatis di commit ke database
// - Untuk memulai transaksi, kita bisa menggunakan function (DB) Begin(),
// 	 dimana akan menghasilkan struct Tx yang merupakan representasi Transaction
// - Struct Tx ini yang kita gunakan sebagai pengganti DB untuk melakukan
// 	 transaksi, dimana hampir semua function di DB ada di Tx, seperti Exec,
// 	 Query atau Prepare
// - Setelah selesai proses transaksi, kita bisa gunakan function (Tx) Commit()
// 	 untuk melakukan commit atau Rollback()

func TestDBTransaction(t *testing.T) {
	db := GetConnection()
	ctx := context.Background()

	tx, err := db.Begin()

	if err != nil {
		panic(err)
	}

	query := "INSERT INTO comments(comment) VALUES (?)"
	stmt, err := db.PrepareContext(ctx, query)

	if err != nil {
		panic(err)
	}

	defer stmt.Close()

	for i := 0; i < 10; i++ {
		comment := "email" + strconv.Itoa(i) + "@gmail.com"
		res, err := stmt.ExecContext(ctx, comment)
		if err != nil {
			panic(err)
		}

		id, err := res.LastInsertId()
		if err != nil {
			panic(err)
		}

		fmt.Println("Insert id ", id)
	}

	err = tx.Rollback()
	if err != nil {
		panic(err)
	}
}
