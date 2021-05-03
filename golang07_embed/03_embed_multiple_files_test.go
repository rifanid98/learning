package golang07_embed

import (
	"embed"
	"fmt"
	"testing"
)

// # Embed Multiple Files
// - Kadang ada kebutuhan kita ingin melakukan embed beberapa file sekaligus
// - Hal ini juga bisa dilakukan menggunakan embed package
// - Kita bisa menambahkan komentar //go:embed lebih dari satu baris
// - Selain itu variable nya bisa kita gunakan tipe data embed.FS

//go:embed a.txt
//go:embed b.txt
//go:embed c.txt
var files embed.FS

func TestMultipleFiles(t *testing.T) {
	a, _ := files.ReadFile("a.txt")
	fmt.Println(string(a))

	b, _ := files.ReadFile("b.txt")
	fmt.Println(string(b))

	c, _ := files.ReadFile("c.txt")
	fmt.Println(string(c))
}
