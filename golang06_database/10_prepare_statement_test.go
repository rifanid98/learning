package golang06_database

import (
	"context"
	"fmt"
	"strconv"
	"testing"
)

// # Query atau Exec dengan Parameter
// - Saat kita menggunakan Function Query atau Exec yang menggunakan parameter,
// 	 sebenarnya implementasi dibawah nya menggunakan Prepare Statement
// - Jadi tahapan pertama statement nya disiapkan terlebih dahulu, setelah itu
// 	 baru di isi dengan parameter
// - Kadang ada kasus kita ingin melakukan beberapa hal yang sama sekaligus,
// 	 hanya berbeda parameternya. Misal insert data langsung banyak
// - Pembuatan Prepare Statement bisa dilakukan dengan manual, tanpa harus
// 	 mennggunakan Query atau Exec dengan parameter

// # Prepare Statement
// - Saat kita membuat Prepare Statement, secara otomatis akan mengenali koneksi
// 	 database yang digunakan
// - Sehingga ketika kita mengeksekusi Prepare Statement berkali-kali, maka akan
// 	 menggunakan koneksi yang sama dan lebih efisien karena pembuatan prepare
// 	 statement nya hanya sekali diawal saja
// - Jika menggunakan Query dan Exec dengan parameter, kita tidak bisa menjamin
// 	 bahwa koneksi yang digunakan akan sama, oleh karena itu, bisa jadi prepare
// 	 statement akan selalu dibuat berkali-kali walaupun kita menggunakan SQL
// 	 yang sama
// - Untuk membuat Prepare Statement, kita bisa menggunakan function (DB)
// 	 Prepare(context, sql)
// - Prepare Statement direpresentasikan dalam struct database/sql.Stmt
// - Sama seperti resource sql lainnya, Stmt harus di Close() jika sudah tidak
// 	 digunakan lagi

func TestPrepareStatement(t *testing.T) {
	db := GetConnection()
	ctx := context.Background()

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

		fmt.Println("Comment id ", id)
	}
}
