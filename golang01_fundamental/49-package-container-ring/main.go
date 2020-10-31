package main

import (
	"container/ring"
	"fmt"
	"strconv"
)

/**
#Package container/ring#
Package ini sama seperti container/list, hanya saja
jika container/list itu ketika sudah mencapai akhir
dari listnya, akan menampilkan nilai <nil>. Sedangkan
di container/ring ini, ketika sudah mencapai akhir
dari list, makan akan kembali lagi ke awal dan begitu
seterusnya.

Namun di container/ring ini, jumlah data harus didfinisikan
terlebih dahulu. jadi tidak bisa menambah data sesuai
keinginan kita.
*/
func main() {
	var dataRing *ring.Ring = ring.New(5)
	for i := 0; i < dataRing.Len(); i++ {
		dataRing.Value = "Value " + strconv.FormatInt(int64(i), 10)
		dataRing = dataRing.Next()
	}

	dataRing.Do(func(value interface{}) {
		fmt.Println(value)
	})
}
