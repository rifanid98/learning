package golang04_goroutines

import (
	"fmt"
	"sync"
	"sync/atomic"
	"testing"
)

// # Atomic
// - Go-Lang memiliki package yang bernama sync/atomic
// - Atomic merupakan package yang digunakan untuk menggunakan data
// 	 primitive secara aman pada proses concurrent
// - Contohnya sebelumnya kita telah menggunakan Mutex untuk melakukan
// 	 locking ketika ingin menaikkan angka di counter. Hal ini sebenarnya
// 	 bisa digunakan menggunakan Atomic package
// - Ada banyak sekali function di atomic package, kita bisa eksplore
// 	 sendiri di halaman dokumentasinya
// - https://golang.org/pkg/sync/atomic/

func TestAtomic(t *testing.T) {
	var group = sync.WaitGroup{}
	var counter int64 = 0

	for i := 0; i < 100; i++ {
		group.Add(1)
		go func() {
			for j := 0; j < 100; j++ {
				atomic.AddInt64(&counter, 1)
				fmt.Println("Counter ", counter)
			}

			group.Done()
		}()
	}

	group.Wait()
	fmt.Println("Total Counter ", counter)
}
