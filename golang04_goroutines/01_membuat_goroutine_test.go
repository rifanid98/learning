package golang04_goroutines

import (
	"fmt"
	"testing"
	"time"
)

func RunHelloWorld() {
	fmt.Println("Hello World")
}

// # Membuat Goroutine
// - Untuk membuat goroutine di Golang sangatlah sederhana
// - Kita hanya cukup menambahkan perintah go sebelum memanggil function yang akan
// 	 kita jalankan dalam goroutine
// - Saat sebuah function kita jalankan dalam goroutine, function tersebut akan berjalan
// 	 secara asynchronous, artinya tidak akan ditunggu sampai function tersebut selesai
// - Aplikasi akan lanjut berjalan ke kode program selanjutnya tanpa menunggu goroutine
// 	 yang kita buat selesai

func TestCreateGoroutines(t *testing.T) {
	go RunHelloWorld()
	fmt.Println("create goroutines")

	time.Sleep(1 * time.Second)
}
