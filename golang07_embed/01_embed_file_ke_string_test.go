package golang07_embed

import (
	_ "embed"
	"fmt"
	"testing"
)

// # Embed File ke String
// - Embed file bisa kita lakukan ke variable dengan tipe data string
// - Secara otomatis isi file akan dibaca sebagai text dan masukkan ke
// 	 variable tersebut

//go:embed file.txt
var file string

func TestString(t *testing.T) {
	fmt.Println("Isi file : ", file)
}
