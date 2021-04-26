package helper

import "testing"

// # Benchmark
// - Selain unit test, Go-Lang testing package juga mendukung melakukan benchmark
// - Benchmark adalah mekanisme menghitung kecepatan performa kode aplikasi kita
// - Benchmark di Go-Lang dilakukan dengan cara secara otomatis melakukan iterasi kode
// 	 yang kita panggil berkali-kali sampai waktu tertentu
// - Kita tidak perlu menentukan jumlah iterasi dan lamanya, karena itu sudah diatur
// 	 oleh testing.B bawaan dari testing package

// # testing.B
// - testing.B adalah struct yang digunakan untuk melakukan benchmark.
// - testing.B mirip dengan testing.T, terdapat function Fail(), FailNow(), Error(),
// 	 Fatal() dan lain-lain
// - Yang membedakan, ada beberapa attribute dan function tambahan yang digunakan untuk
// 	 melakukan benchmark
// - Salah satunya adalah attribute N, ini digunakan untuk melakukan total iterasi
// 	 sebuah benchmark

// # Cara Kerja Benchmark
// - Cara kerja benchmark di Go-Lang sangat sederhana
// - Gimana kita hanya perlu membuat perulangan sejumlah N attribute
// - Nanti secara otomatis Go-Lang akan melakukan eksekusi sejumlah perulangan yang
// 	 ditentukan secara otomatis, lalu mendeteksi berapa lama proses tersebut berjalan,
// 	 dan disimpulkan performa benchmark nya dalam waktu

// # Becnchmark Function
// _ Mirip seperti unit test, untuk benchmark pun, di Go-Lang sudah ditentukan nama
//   function nya, harus diawali dengan kata Benchmark, misal BenchmarkHelloWorld,
// 	 BenchmarkXxx
// _ Selain itu, harus memiliki parameter (b *testing.B)
// _ Dan tidak boleh mengembalikan return value
// _ Untuk nama file benchmark, sama seperti unit test, diakhiri dengan _test, misal
// 	 hello_world_test.go

// # Menjalankan Benchmark
// - Untuk menjalankan seluruh benchmark di module, kita bisa menggunakan perintah sama seperti test, namun ditambahkan parameter bench :
//   go test -v -bench=.
// - Jika kita hanya ingin menjalankan benchmark tanpa unit test, kita bisa gunakan perintah :
//   go test -v -run=NotMathUnitTest -bench=.
// - Kode diatas selain menjalankan benchmark, akan menjalankan unit test juga, jika kita hanya ingin menjalankan benchmark tertentu, kita bisa gunakan perintah :
//   go test -v -run=NotMathUnitTest -bench=BenchmarkTest
// - Jika kita menjalankan benchmark di root module dan ingin semua module dijalankan, kita bisa gunakan perintah :
//   go test -v -bench=. ./...

func BenchmarkTest(b *testing.B) {
	for i := 0; i < b.N; i++ {
		HelloWorld("Adnin")
	}
}
