package golang04_goroutines

import (
	"fmt"
	"testing"
	"time"
)

// Channel
// - Channel adalah tempat komunikasi secara synchronous yang bisa dilakukan
//   oleh goroutine
// - Di Channel terdapat pengirim dan penerima, biasanya pengirim dan penerima
// 	 adalah goroutine yang berbeda
// - Saat melakukan pengiriman data ke Channel, goroutine akan ter-block, sampai
// 	 ada yang menerima data tersebut
// - Maka dari itu, channel disebut sebagai alat komunikasi synchronous (blocking)
// - Channel cocok sekali sebagai alternatif seperti mekanisme async await yang
// 	 terdapat di beberapa bahasa pemrograman lain

// # Karakteristik Channel
// - Secara default channel hanya bisa menampung satu data, jika kita ingin
// 	 menambahkan data lagi, harus menunggu data yang ada di channel diambil
// - Channel hanya bisa menerima satu jenis data
// - Channel bisa diambil dari lebih dari satu goroutine
// - Channel harus di close jika tidak digunakan, atau bisa menyebabkan memory leak

// # Membuat Channel
// - Channel di Go-Lang direpresentasikan dengan tipe data chan
// - Untuk membuat channel sangat mudah, kita bisa menggunakan make(), mirip ketika
// 	 membuat map
// - Namun saat pembuatan channel, kita harus tentukan tipe data apa yang bisa
// 	 dimasukkan kedalam channel tersebut

func TestCreateChannel(t *testing.T) {
	channel := make(chan string)
	close(channel)
}

// Mengirim Data Ke dan Mengambil Data Dari Channel
// - Seperti yang sudah dibahas sebelumnya, channel bisa digunakan untuk mengirim dan
// 	 menerima data
// - Untuk mengirim data, kita bisa gunakan kode : channel <- data
// - Sedangkan untuk menerima data, bisa gunakan kode : data <- channel
// - Jika selesai, jangan lupa untuk menutup channel menggunakan function close()

func TestSendReceiveChannel(t *testing.T) {
	channel := make(chan string)

	go func() {
		time.Sleep(1 * time.Second)
		channel <- "Adnin"
	}()

	name := <-channel
	fmt.Println(name)
	close(channel)
}

// # Channel Sebagai Paramater
// - Dalam kenyataan pembuatan aplikasi, seringnya kita akan mengirim channel
// 	 ke function lain via parameter
// - Sebelumnya kita tahu bahkan di Go-Lang by default, parameter adalah pass
// 	 by value, artinya value akan diduplikasi lalu dikirim ke function parameter,
// 	 sehingga jika kita ingin mengirim data asli, kita biasa gunakan pointer
// 	 (agar pass by reference).
// - Berbeda dengan Channel, kita tidak perlu melakukan hal tersebut

func setDataChannel(channel chan string, data string) {
	time.Sleep(1 * time.Second)
	channel <- data
}
func TestChannelAsParameter(t *testing.T) {
	channel := make(chan string)

	go setDataChannel(channel, "Adnin")

	name := <-channel
	fmt.Println(name)
	close(channel)
}

// # Channel In & Channel Out
// - Saat kita mengirim channel sebagai parameter, isi function tersebut
// 	 bisa mengirim dan menerima data dari channel tersebut
// - Kadang kita ingin memberi tahu terhadap function, misal bahwa channel
// 	 tersebut hanya digunakan untuk mengirim data, atau hanya dapat digunakan
// 	 untuk menerima data
// - Hal ini bisa kita lakukan di parameter dengan cara menandai apakah channel
// 	 ini digunakan untuk in (mengirim data) atau out (menerima data)

func OnlyIn(channel chan<- string, data string) {
	time.Sleep(1 * time.Second)
	channel <- data
}

func OnlyOut(channel <-chan string, data *string) {
	time.Sleep(2 * time.Second)
	*data = <-channel
}

func TestChannelOnlyInOnlyOut(t *testing.T) {
	channel := make(chan string)

	go OnlyIn(channel, "Adnin")

	var name string
	go OnlyOut(channel, &name)
	time.Sleep(2 * time.Second)
	fmt.Println(name)
	close(channel)
}
