package helper

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

// # Testify
// - Salah satu library assertion yang paling populer di Go-Lang adalah Testify
// - Kita bisa menggunakan library ini untuk melakukan assertion terhadap result data di unit test
// - https://github.com/stretchr/testify
// - Kita bisa menambahkannya di Go module kita :
// - go get github.com/stretchr/testify

// # Assertion
// - Melakukan pengecekan di unit test secara manual menggunakan if else
//	 sangatlah menyebalkan
// - Apalagi jika result data yang harus di cek itu banyak
// - Oleh karena itu, sangat disarankan untuk menggunakan Assertion untuk
//	 melakukan pengecekan
// - Sayangnya, Go-Lang tidak menyediakan package untuk assertion, sehingga
//	 kita butuh menambahkan library untuk melakukan assertion ini

func TestAssertion(t *testing.T) {
	result := HelloWorld("Adninn")
	failMessage := "Result must be Hello Adnin"
	assert.Equal(t, "Hello Adnin", result, failMessage)
	fmt.Println("Test Selesai") // dieksekusi karena memanggil t.Fail()
}

// # Assert vs Require
// - Testify menyediakan dua package untuk assertion, yaitu assert dan require
// - Saat kita menggunakan assert, jika pengecekan gagal, maka assert akan
//	 memanggil Fail(), artinya eksekusi unit test akan tetap dilanjutkan
// - Sedangkan jika kita menggunakan require, jika pengecekan gagal, maka
//   require akan memanggil FailNow(), artinya eksekusi unit test tidak akan
//   dilanjutkan

func TestRequire(t *testing.T) {
	result := HelloWorld("Adninn")
	failMessage := "Result must be Hello Adnin"
	require.Equal(t, "Hello Adnin", result, failMessage)
	fmt.Println("Test Selesai") // tidak dieksekusi karena memanggil t.Fatal()
}
