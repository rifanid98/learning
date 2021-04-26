package helper

import (
	"fmt"
	"testing"
)

// # Menggagalkan Unit Test
// - Menggagalkan unit test menggunakan panic bukanlah hal yang bagus
// - Go-Lang sendiri sudah menyediakan cara untuk menggagalkan unit test
//	 menggunakan testing.T
// - Terdapat function Fail(), FailNow(), Error() dan Fatal() jika kita ingin
//	 menggagalkan unit test

// # t.Fail() dan t.FailNow()
// - Terdapat dua function untuk menggagalkan unit test, yaitu Fail() dan
//	 FailNow(). Lantas apa bedanya?
// - Fail() akan menggagalkan unit test, namun tetap melanjutkan eksekusi unit
//	 test. Namun diakhir ketika selesai, maka unit test tersebut dianggap gagal
// - FailNow() akan menggagalkan unit test saat ini juga, tanpa melanjutkan
//	 eksekusi unit test

func TestHelloWorldFail(t *testing.T) {
	result := HelloWorld("Adninn")
	if result != "Hello Adnin" {
		t.Fail()
	}

	fmt.Println("Dieksekusi") // Dieksekusi
}

func TestHelloWorldFailNow(t *testing.T) {
	result := HelloWorld("Adninn")
	if result != "Hello Adnin" {
		t.FailNow()
	}

	fmt.Println("Tidak Dieksekusi") // Tidak dieksekusi
}

// # t.Error(args...) dan t.Fatal(args...)
// - Selain Fail() dan FailNow(), ada juga Error() dan Fatal()
// - Error() function lebih seperti melakukan log (print) error, namun setelah
//	 melakukan log error, dia akan secara otomatis memanggil function Fail(),
//	 sehingga mengakibatkan unit test dianggap gagal
// - Namun karena hanya memanggil Fail(), artinya eksekusi unit test akan tetap
//	 berjalan sampai selesai
// - Fatal() mirip dengan Error(), hanya saja, setelah melakukan log error, dia
//	 akan memanggil FailNow(), sehingga mengakibatkan eksekusi unit test
//	 berhenti

func TestHelloWorldError(t *testing.T) {
	result := HelloWorld("Adninn")
	if result != "Hello Adnin" {
		t.Error("Result must be Hello Adnin")
	}

	fmt.Println("Dieksekusi") // Dieksekusi
}

func TestHelloWorldFatal(t *testing.T) {
	result := HelloWorld("Adninn")
	if result != "Hello Adnin" {
		t.Fatal("Result must be Hello Adnin")
	}

	fmt.Println("Tidak Dieksekusi") // Tidak dieksekusi
}
