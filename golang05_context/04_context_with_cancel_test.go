package golang05_context

import (
	"context"
	"fmt"
	"runtime"
	"testing"
	"time"
)

// # Context With Cancel
// - Selain menambahkan value ke context, kita juga bisa menambahkan sinyal
// 	 cancel ke context
// - Kapan sinyal cancel diperlukan dalam context?
// - Biasanya ketika kita butuh menjalankan proses lain, dan kita ingin bisa
// 	 memberi sinyal cancel ke proses tersebut
// - Biasanya proses ini berupa goroutine yang berbeda, sehingga dengan
// 	 mudah jika kita ingin membatalkan eksekusi goroutine, kita bisa
// 	 mengirim sinyal cancel ke context nya
// - Namun ingat, goroutine yang menggunakan context, tetap harus melakukan
// 	 pengecekan terhadap context nya, jika tidak, tidak ada gunanya
// - Untuk membuat context dengan cancel signal, kita bisa menggunakan
// 	 function context.WithCancel(parent)

func createCounterLeak() chan int {
	destination := make(chan int)

	go func() {
		defer close(destination)
		counter := 1
		for {
			destination <- counter
			counter++
		}
	}()

	return destination
}

func TestGoroutineLeak(t *testing.T) {
	fmt.Println("Total Goroutine ", runtime.NumGoroutine())

	counter := createCounterLeak()

	for n := range counter {
		fmt.Println(n)
		if n == 10 {
			break
		}
	}

	fmt.Println("Total Goroutine ", runtime.NumGoroutine())
}

func createCounterWithContext(ctx context.Context) chan int {
	destination := make(chan int)

	go func() {
		defer close(destination)
		counter := 1
		for {
			select {
			case <-ctx.Done():
				return
			default:
				destination <- counter
				counter++
			}
		}
	}()

	return destination
}

func TestContextWithCancel(t *testing.T) {
	fmt.Println("Total Goroutine ", runtime.NumGoroutine())

	parent := context.Background()
	ctx, cancel := context.WithCancel(parent)

	counter := createCounterWithContext(ctx)

	for n := range counter {
		fmt.Println(n)
		if n == 10 {
			break
		}
	}

	cancel()

	// cek untuk memastikan bahwa goroutinenya sudah dimatikan
	time.Sleep(1 * time.Second)

	fmt.Println("Total Goroutine ", runtime.NumGoroutine())
}
