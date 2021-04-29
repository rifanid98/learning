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

func TestTimeTimer(t *testing.T) {
	timer := time.NewTimer(5 * time.Second)
	fmt.Println(time.Now())

	time := <-timer.C
	fmt.Println(time)
}

// # time.After
// - Kadang kita hanya butuh channel nya saja, tidak membutuhkan data Timer nya
// - Untuk melakukan hal itu kita bisa menggunakan function time.After(duration)

func TestTimeAfter(t *testing.T) {
	channel := time.After(5 * time.Second)
	fmt.Println(time.Now())

	time := <-channel
	fmt.Println(time)
}
