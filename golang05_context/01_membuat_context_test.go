package golang05_context

import (
	"context"
	"fmt"
	"testing"
)

// # Membuat Context
// - Karena Context adalah sebuah interface, untuk membuat context kita butuh sebuah
// 	 struct yang sesuai dengan kontrak interface Context
// - Namun kita tidak perlu membuatnya secara manual
// - Di Golang package context terdapat function yang bisa kita gunakan untuk membuat
// 	 Context

// # Function Membuat Context
// -----------------------------------------------------------------------------------
// |				Function				|		Keterangan																					 |
// -----------------------------------------------------------------------------------
// |	context.Background()	| Membuat context kosong. Tidak pernah dibatalkan, tidak |
// |												| pernah timeout, dan tidak memiliki value apapun. 			 |
// |												| Biasanya digunakan di main function atau dalam test, 	 |
// |												| atau dalam awal proses request terjadi.								 |
// -----------------------------------------------------------------------------------
// |	context.TODO()			  | Membuat context kosong seperti Background(), namun 		 |
// |												| biasanya menggunakan ini ketika belum jelas context    |
// |												| apa yang ingin digunakan.															 |
// -----------------------------------------------------------------------------------

func TestContext(t *testing.T) {
	background := context.Background()
	fmt.Println(background)

	todo := context.TODO()
	fmt.Println(todo)
}
