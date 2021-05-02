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
