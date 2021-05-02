package golang06_database

import (
	"context"
	"fmt"
	"testing"
)

// # Eksekusi Perintah SQL
// - Saat membuat aplikasi menggunakan database, sudah pasti kita ingin
// 	 berkomunikasi dengan database menggunakan perintah SQL
// - Di Golang juga menyediakan function yang bisa kita gunakan untuk mengirim
// 	 perintah SQL ke database menggunakan function (DB)
// 	 ExecContext(context, sql, params)
// - Ketika mengirim perintah SQL, kita butuh mengirimkan context, dan seperti
// 	 yang sudah pernah kita pelajari di course Golang Context, dengan context,
// 	 kita bisa mengirim sinyal cancel jika kita ingin membatalkan pengiriman
// 	 perintah SQL nya

func TestExecSQLCommand(t *testing.T) {
	db := GetConnection()
	defer db.Close()

	ctx := context.Background()
	query := "INSERT INTO customer(id, name) VALUES ('adnin', 'ADNIN')"
	_, err := db.ExecContext(ctx, query)
	if err != nil {
		panic(err)
	}

	fmt.Println("Success insert data to datbase")
}
