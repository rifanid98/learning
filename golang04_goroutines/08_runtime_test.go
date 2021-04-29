package golang04_goroutines

import (
	"fmt"
	"runtime"
	"testing"
)

// # GOMAXPROCS
// - Sebelumnya diawal kita sudah bahas bahwa goroutine itu sebenarnya
// 	 dijalankan di dalam Thread
// - Pertanyaannya, seberapa banyak Thread yang ada di Go-Lang ketika
// 	 aplikasi kita berjalan?
// - Untuk mengetahui berapa jumlah Thread, kita bisa menggunakan GOMAXPROCS,
// 	 yaitu sebuah function di package runtime yang bisa kita gunakan untuk
// 	 mengubah jumlah thread atau mengambil jumlah thread
// - Secara default, jumlah thread di Go-Lang itu sebanyak jumlah CPU di
// 	 komputer kita.
// - Kita juga bisa melihat berapa jumlah CPU kita dengan menggunakan function
// 	 runtime.NumCpu()

func TestRuntime(t *testing.T) {
	totalCPU := runtime.NumCPU()
	fmt.Println("Total CPU ", totalCPU)

	totalThread := runtime.GOMAXPROCS(-1)
	fmt.Println("Total Thread ", totalThread)

	totalGoroutine := runtime.NumGoroutine()
	fmt.Println("Total Goroutine ", totalGoroutine)
}

func TestChangeThreadNumber(t *testing.T) {
	runtime.GOMAXPROCS(20)
	totalThread := runtime.GOMAXPROCS(-1)
	fmt.Println("Total Thread ", totalThread)
}
