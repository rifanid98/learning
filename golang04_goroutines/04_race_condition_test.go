package golang04_goroutines

import (
	"fmt"
	"testing"
	"time"
)

// # Race Condition
// - Saat kita menggunakan goroutine, dia tidak hanya berjalan secara
// 	 concurrent, tapi bisa parallel juga, karena bisa ada beberapa thread
// 	 yang berjalan secara parallel
// - Hal ini sangat berbahaya ketika kita melakukan manipulasi data variable
// 	 yang sama oleh beberapa goroutine secara bersamaan
// - Hal ini bisa menyebabkan masalah yang namanya Race Condition

func TestRaceCondition(t *testing.T) {
	x := 0
	for i := 0; i < 1000; i++ {
		go func() {
			for j := 0; j < 100; j++ {
				x += 1
			}
		}()

	}

	time.Sleep(7 * time.Second)
	fmt.Println("Counter x ", x)
}
