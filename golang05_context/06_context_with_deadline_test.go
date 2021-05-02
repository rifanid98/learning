package golang05_context

import (
	"context"
	"fmt"
	"runtime"
	"testing"
	"time"
)

// # Context With Deadline
// - Selain menggunakan timeout untuk melakukan cancel secara otomatis,
// 	 kita juga bisa menggunakan deadline
// - Pengaturan deadline sedikit berbeda dengan timeout, jika timeout kita
// 	 beri waktu dari sekarang, kalo deadline ditentukan kapan waktu timeout
// 	 nya, misal jam 12 siang hari ini
// - Untuk membuat context dengan cancel signal secara otomatis menggunakan
// 	 deadline, kita bisa menggunakan function context.WithDeadline(parent, time)

func createCounterDeadline(ctx context.Context) chan int {
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
				time.Sleep(1 * time.Second)
			}
		}
	}()

	return destination
}

func TestContextWithDeadline(t *testing.T) {
	fmt.Println("Total Goroutine ", runtime.NumGoroutine())

	parent := context.Background()
	ctx, cancel := context.WithDeadline(parent, time.Now().Add(5*time.Second))

	defer cancel()

	destination := createCounterDeadline(ctx)
	for n := range destination {
		fmt.Println(n)
	}

	fmt.Println("Total Goroutine", runtime.NumGoroutine())
}
