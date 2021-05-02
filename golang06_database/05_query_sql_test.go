package golang06_database

import (
	"context"
	"fmt"
	"testing"
)

// # Query SQL
// - Untuk operasi SQL yang tidak membutuhkan hasil, kita bisa menggunakan
// 	 perintah Exec, namun jika kita membutuhkan result, seperti SELECT SQL,
// 	 kita bisa menggunakan function yang berbeda
// - Function untuk melakukan query ke database, bisa menggunakan function (DB)
// 	 QueryContext(context, sql, params)

func TestQuerySQL(t *testing.T) {
	db := GetConnection()
	defer db.Close()

	ctx := context.Background()
	query := "SELECT * FROM customer"
	rows, err := db.QueryContext(ctx, query)
	if err != nil {
		panic(err)
	}

	fmt.Println("Success get data from database")
	defer rows.Close()
}

// # Rows
// - Hasil Query function adalah sebuah data structs sql.Rows
// - Rows digunakan untuk melakukan iterasi terhadap hasil dari query
// - Kita bisa menggunakan function (Rows) Next() (boolean) untuk melakukan
// 	 iterasi terhadap data hasil query, jika return data false, artinya sudah
// 	 tidak ada data lagi didalam result
// - Untuk membaca tiap data, kita bisa menggunakan (Rows) Scan(columns...)
// - Dan jangan lupa, setelah menggunakan Rows, jangan lupa untuk menutupnya
// 	 menggunakan (Rows) Close()

func TestRows(t *testing.T) {
	db := GetConnection()
	defer db.Close()

	ctx := context.Background()
	query := "SELECT * FROM customer"
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
		fmt.Println("id : ", id)
		fmt.Println("name : ", name)
	}

	fmt.Println("Success get data from database")
	defer rows.Close()
}
