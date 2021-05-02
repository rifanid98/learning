package golang06_database

import (
	"context"
	"database/sql"
	"fmt"
	"testing"
	"time"
)

// # Tipe Data Column
// - Sebelumnya kita hanya membuat table dengan tipe data di kolom nya berupa
// 	 VARCHAR
// - Untuk VARCHAR di database, biasanya kita gunakan String di Golang
// - Bagaimana dengan tipe data yang lain?
// - Apa representasinya di Golang, misal tipe data timestamp, date dan lain-lain

// # Mapping Tipe Data
// ------------------------------------------------------
// |		Tipe Data Database 		|		Tipe Data Golang			|
// ------------------------------------------------------
// |		VARCHAR, CHAR					|		string								|
// |		INT, BIGINT 					|		int32, int64					|
// |		FLOAT, DOUBLE 				|		float32, float64			|
// |		BOOLEAN 							|		bool									|
// |		DATE, DATETIME, 			|													|
// |		TIME, TIMESTAMP 			| 	time.Time							|
// ------------------------------------------------------

func TestTipeData(t *testing.T) {
	db := GetConnection()
	defer db.Close()

	ctx := context.Background()
	query := "SELECT id, name, email, balance, rating, birth_date, married, created_at FROM customer"
	rows, err := db.QueryContext(ctx, query)
	if err != nil {
		panic(err)
	}

	for rows.Next() {
		var id, name, email string
		var balance int32
		var rating float64
		var birth_date, created_at time.Time
		var married bool
		err := rows.Scan(&id, &name, &email, &balance, &rating, &birth_date, &married, &created_at)
		if err != nil {
			panic(err)
		}
		fmt.Println("id \t\t: ", id)
		fmt.Println("name \t\t: ", name)
		fmt.Println("email \t\t: ", email)
		fmt.Println("balance \t: ", balance)
		fmt.Println("rating \t\t: ", rating)
		fmt.Println("birth_date \t: ", birth_date)
		fmt.Println("married \t: ", married)
		fmt.Println("created_at \t: ", created_at)
	}

	fmt.Println("Success get data from database")
	defer rows.Close()
}

// # Nullable Type
// - Golang database tidak mengerti dengan tipe data NULL di database
// - Oleh karena itu, khusus untuk kolom yang bisa NULL di database, akan jadi
// 	 masalah jika kita melakukan Scan secara bulat-bulat menggunakan tipe data
// 	 representasinya di Golang

// # Tipe Data Nullable
// --------------------------------------------------------
// |		Tipe Data Golang 		|			Tipe Data Nullable			|
// --------------------------------------------------------
// |		string							|		database/sql.NullString		|
// |		bool							 	|		database/sql.NullBool			|
// |		float64							|		database/sql.NullFloat64	|
// |		int32							 	|		database/sql.NullInt32		|
// |		int64							 	|		database/sql.NullInt64		|
// |		time.Time 					|		database/sql.NullTime			|
// --------------------------------------------------------

func TestNullableType(t *testing.T) {
	db := GetConnection()
	defer db.Close()

	ctx := context.Background()
	query := "SELECT id, name, email, balance, rating, birth_date, married, created_at FROM customer"
	rows, err := db.QueryContext(ctx, query)
	if err != nil {
		panic(err)
	}

	for rows.Next() {
		var id, name string
		var email sql.NullString
		var balance int32
		var rating float64
		var birth_date sql.NullTime
		var created_at time.Time
		var married bool
		err := rows.Scan(&id, &name, &email, &balance, &rating, &birth_date, &married, &created_at)
		if err != nil {
			panic(err)
		}
		fmt.Println("id \t\t: ", id)
		fmt.Println("name \t\t: ", name)
		if email.Valid {
			fmt.Println("email \t\t: ", email.String)
		} else {
			fmt.Println("email \t\t: null")
		}
		fmt.Println("balance \t: ", balance)
		fmt.Println("rating \t\t: ", rating)
		if birth_date.Valid {
			fmt.Println("birth_date \t: ", birth_date.Time)
		} else {
			fmt.Println("birth_date \t: null")
		}
		fmt.Println("married \t: ", married)
		fmt.Println("created_at \t: ", created_at)

		fmt.Println("-------------------------------------------")
	}

	fmt.Println("Success get data from database")
	defer rows.Close()
}
