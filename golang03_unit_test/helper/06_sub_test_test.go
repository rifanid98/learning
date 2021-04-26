package helper

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

// # Sub Test
// - Go-Lang mendukung fitur pembuatan function unit test di dalam function
// 	 unit test
// - Fitur ini memang sedikit aneh dan jarang sekali dimiliki di unit test di
// 	 bahasa pemrograman yang lainnya
// - Untuk membuat sub test, kita bisa menggunakan function Run()

// # Menjalankan Hanya Sub Test
// - go test -run TestNamaFunction
// - go test -run TestNamaFunction/NamaSubTest
// - go test -run /NamaSubTest

func TestSubTest(t *testing.T) {
	t.Run("SubTest1", func(t *testing.T) {
		result := HelloWorld("Adnin")
		assert.Equal(t, "Hello Adnin", result)
	})
	t.Run("SubTest2", func(t *testing.T) {
		result := HelloWorld("Adnin")
		assert.Equal(t, "Hello Adnin", result)
	})
}
