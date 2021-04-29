package golang04_goroutines

import (
	"fmt"
	"testing"
	"time"
)

// # time.Timer
// - Timer adalah representasi satu kejadian
// - Ketika waktu timer sudah expire, maka event akan dikirim ke dalam channel
// - Untuk membuat Timer kita bisa menggunakan time.NewTimer(duration)

func TestTimer(t *testing.T) {
	timer := time.NewTimer(5 * time.Second)
	fmt.Println(time.Now())

	time := <-timer.C
	fmt.Println(time)
}
