package golang05_context

import (
	"context"
	"fmt"
	"testing"
)

// # Context With Value
// - Pada saat awal membuat context, context tidak memiliki value
// - Kita bisa menambah sebuah value dengan data Pair (key - value) ke
// 	 dalam context
// - Saat kita menambah value ke context, secara otomatis akan tercipta
// 	 child context baru, artinya original context nya tidak akan berubah
// 	 sama sekali
// - Untuk membuat menambahkan value ke context, kita bisa menggunakan
// 	 function context.WithValue(parent, key, value)

func TestContextWithValue(t *testing.T) {
	contextA := context.Background()

	contextB := context.WithValue(contextA, "b", "B")
	contextC := context.WithValue(contextA, "c", "C")

	contextD := context.WithValue(contextB, "d", "D")
	contextE := context.WithValue(contextB, "e", "E")

	contextF := context.WithValue(contextC, "f", "F")

	// Tampilan hierarki konteks
	fmt.Println(contextA)
	fmt.Println(contextB)
	fmt.Println(contextC)
	fmt.Println(contextD)
	fmt.Println(contextE)
	fmt.Println(contextF)

	// Ambil nilai dari konteks
	fmt.Println(contextF.Value("f")) // dapat
	fmt.Println(contextF.Value("c")) // dapat milik parent
	fmt.Println(contextF.Value("b")) // tidak dapat, beda parent
	fmt.Println(contextA.Value("b")) // tidak bisa mengambil data child

}
