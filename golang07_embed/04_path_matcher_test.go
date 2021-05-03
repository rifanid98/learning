package golang07_embed

import (
	"embed"
	"fmt"
	"testing"
)

// # Path Matcher
// - Selain manual satu per satu, kita bisa mengguakan patch matcher untuk
// 	 membaca multiple file yang kita inginkan
// - Ini sangat cocok ketika misal kita punya pola jenis file yang kita
// 	 inginkan untuk kita baca
// - Caranya, kita perlu menggunakan path matcher seperti pada package
// 	 function path.Match

//go:embed files/*.txt
var path embed.FS

func TestPathMatcher(t *testing.T) {
	dir, _ := path.ReadDir("files")
	for _, entry := range dir {
		if !entry.IsDir() {
			fmt.Println(entry.Name())
			content, _ := path.ReadFile("files/" + entry.Name())
			fmt.Println("Content : ", string(content))
		}
	}
}
