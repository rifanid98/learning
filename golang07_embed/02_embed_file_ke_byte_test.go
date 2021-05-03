package golang07_embed

import (
	_ "embed"
	"io/fs"
	"io/ioutil"
	"testing"
)

// # Embed File ke []byte
// - Selain ke tipe data String, embed file juga bisa dilakukan ke variable
// 	 tipe data []byte
// - Ini cocok sekali jika kita ingin melakukan embed file dalam bentuk binary,
// 	 seperti gambar dan lain-lain

//go:embed dompet.png
var logo []byte

func TestByte(t *testing.T) {
	err := ioutil.WriteFile("dompet2.png", logo, fs.ModePerm)
	if err != nil {
		panic(err)
	}
}
