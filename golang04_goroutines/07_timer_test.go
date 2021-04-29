package golang04_goroutines

import (
	"fmt"
	"sync"
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

// # time.AfterFunc
// - Kadang ada kebutuhan kita ingin menjalankan sebuah function dengan delay
// 	 waktu tertentu
// - Kita bisa memanfaatkan Timer dengan menggunakan function time.AfterFunc()
// - Kita tidak perlu lagi menggunakan channel nya, cukup kirim kan function
// 	 yang akan dipanggil ketika Timer mengirim kejadiannya

func TestTimeAfterFunc(t *testing.T) {
	group := sync.WaitGroup{}
	group.Add(1)

	time.AfterFunc(1*time.Second, func() {
		fmt.Println("Execute after 1 second")
		fmt.Println(time.Now())
		group.Done()
	})

	fmt.Println(time.Now())

	group.Wait()
}

// # time.Ticker
// - Ticker adalah representasi kejadian yang berulang
// - Ketika waktu ticker sudah expire, maka event akan dikirim ke dalam channel
// - Untuk membuat ticker, kita bisa menggunakan time.NewTicker(duration)
// - Untuk menghentikan ticker, kita bisa menggunakan Ticker.Stop()

func TestTimeTicker(t *testing.T) {
	ticker := time.NewTicker(1 * time.Second)

	time.AfterFunc(5*time.Second, func() {
		ticker.Stop()
	})

	for tick := range ticker.C {
		fmt.Println(tick)
	}
}

// # time.Tick
// - Kadang kita tidak butuh data Ticker nya, kita hanya butuh channel nya saja
// - Jika demikian, kita bisa menggunakan function timer.Tick(duration), function
// 	 ini tidak akan mengembalikan Ticker, hanya mengembalikan channel timer nya saja

func TestTimeTick(t *testing.T) {
	channel := time.Tick(1 * time.Second)

	for time := range channel {
		fmt.Println(time)
	}
}
