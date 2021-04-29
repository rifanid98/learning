package golang04_goroutines

import (
	"fmt"
	"sync"
	"testing"
	"time"
)

// # sync.Mutex (Mutual Exclusion)
// - Untuk mengatasi masalah race condition tersebut, di Go-Lang terdapat
// 	 sebuah struct bernama sync.Mutex
// - Mutex bisa digunakan untuk melakukan locking dan unlocking, dimana
// 	 ketika kita melakukan locking terhadap mutex, maka tidak ada yang
// 	 bisa melakukan locking lagi sampai kita melakukan unlock
// - Dengan demikian, jika ada beberapa goroutine melakukan lock terhadap
// 	 Mutex, maka hanya 1 goroutine yang diperbolehkan, setelah goroutine
// 	 tersebut melakukan unlock, baru goroutine selanjutnya diperbolehkan
// 	 melakukan lock lagi
// - Ini sangat cocok sebagai solusi ketika ada masalah race condition yang
// 	 sebelumnya kita hadapi

func TestSyncMutex(t *testing.T) {
	var mutex sync.Mutex
	x := 0
	for i := 0; i < 1000; i++ {
		go func() {
			for j := 0; j < 100; j++ {
				mutex.Lock()
				x += 1
				mutex.Unlock()
			}
		}()

	}

	time.Sleep(7 * time.Second)
	fmt.Println("Counter x ", x)
}

// # sync.RWMutex
// - Kadang ada kasus dimana kita ingin melakukan locking tidak hanya
// 	 pada proses mengubah data, tapi juga membaca data
// - Kita sebenarnya bisa menggunakan Mutex saja, namun masalahnya nanti
// 	 akan rebutan antara proses membaca dan mengubah
// - Di Go-Lang telah disediakan struct RWMutex (Read Write Mutex) untuk
// 	 menangani hal ini, dimana Mutex jenis ini memiliki dua lock, lock untuk Read dan lock untuk Write

type BankAccount struct {
	RWMutex sync.RWMutex
	Balance int
}

func (account *BankAccount) AddBalance(amount int) {
	account.RWMutex.Lock()
	account.Balance = account.Balance + amount
	account.RWMutex.Unlock()
}

func (account *BankAccount) GetBalance() int {
	account.RWMutex.RLock()
	balance := account.Balance
	account.RWMutex.RUnlock()
	return balance
}

func TestSyncRWMutex(t *testing.T) {
	account := BankAccount{}

	for i := 0; i < 1000; i++ {
		go func() {
			for j := 0; j < 100; j++ {
				account.AddBalance(1)
				fmt.Println(account.GetBalance())
			}
		}()

	}

	time.Sleep(7 * time.Second)
	fmt.Println("Final Balance : ", account.GetBalance())
}

// # Deadlock
// - Hati-hati saat membuat aplikasi yang parallel atau concurrent,
// 	 masalah yang sering kita hadapi adalah Deadlock
// - Deadlock adalah keadaan dimana sebuah proses goroutine saling
// 	 menunggu lock sehingga tidak ada satupun goroutine yang bisa jalan
// - Sekarang kita coba simulasikan proses deadlock

type UserBalance struct {
	Mutex   sync.Mutex
	Name    string
	Balance int
}

func (user *UserBalance) Lock() {
	user.Mutex.Lock()
	fmt.Println("Lock ", user.Name)
}

func (user *UserBalance) Unlock() {
	user.Mutex.Unlock()
	fmt.Println("Unlock ", user.Name)
}

func (user *UserBalance) Change(amount int) {
	user.Balance = user.Balance + amount
}

func transfer(user1 *UserBalance, user2 *UserBalance, amount int) {
	user1.Lock()
	user1.Change(-amount)

	time.Sleep(1 * time.Second)

	user2.Lock()
	user2.Change(amount)

	time.Sleep(1 * time.Second)

	user1.Unlock()
	user2.Unlock()
}

func TestDeadLock(t *testing.T) {
	user1 := UserBalance{
		Name:    "AdninRifandi",
		Balance: 10_000,
	}

	user2 := UserBalance{
		Name:    "SutantoPutra",
		Balance: 10_000,
	}

	// transfer(&user1, &user2, 1000)
	go transfer(&user1, &user2, 1000)
	go transfer(&user2, &user1, 2000)

	time.Sleep(5 * time.Second)

	fmt.Println("User 1 ", user1.Name, " balance ", user1.Balance)
	fmt.Println("User 2 ", user2.Name, " balance ", user2.Balance)
}

// # sync.WaitGroup
// - WaitGroup adalah fitur yang bisa digunakan untuk menunggu sebuah
// 	 proses selesai dilakukan
// - Hal ini kadang diperlukan, misal kita ingin menjalankan beberapa
// 	 proses menggunakan goroutine, tapi kita ingin semua proses selesai
// 	 terlebih dahulu sebelum aplikasi kita selesai
// - Kasus seperti ini bisa menggunakan WaitGroup
// - Untuk menandai bahwa ada proses goroutine, kita bisa menggunakan
// 	 method Add(int), setelah proses goroutine selesai, kita bisa gunakan method Done()
// - Untuk menunggu semua proses selesai, kita bisa menggunakan method Wait()

func runAsynchronous(group *sync.WaitGroup) {
	defer group.Done()

	group.Add(1)
	fmt.Println("Hello")
	time.Sleep(1 * time.Second)
}

func TestSyncWaitGroup(t *testing.T) {
	group := &sync.WaitGroup{}

	for i := 0; i < 100; i++ {
		go runAsynchronous(group)
	}

	group.Wait()
	fmt.Println("Complete")
}

// # sync.Once
// - Once adalah fitur di Go-Lang yang bisa kita gunakan untuk memastikan bahsa
// 	 sebuah function di eksekusi hanya sekali
// - Jadi berapa banyak pun goroutine yang mengakses, bisa dipastikan bahwa
// 	 goroutine yang pertama yang bisa mengeksekusi function nya
// - Goroutine yang lain akan di hiraukan, artinya function tidak akan dieksekusi
// 	 lagi

func TestSyncOnce(t *testing.T) {
	var counter int

	onlyOnce := func() {
		counter++
	}

	var once sync.Once
	var group sync.WaitGroup

	for i := 0; i < 100; i++ {
		go func() {
			group.Add(1)
			once.Do(onlyOnce)
			group.Done()
		}()
	}

	group.Wait()
	fmt.Println("counter : ", counter)
}

// # sync.Pool
// - Pool adalah implementasi design pattern bernama object pool pattern.
// - Sederhananya, design pattern Pool ini digunakan untuk menyimpan data,
// 	 selanjutnya untuk menggunakan datanya, kita bisa mengambil dari Pool,
// 	 dan setelah selesai menggunakan datanya, kita bisa menyimpan kembali ke
// 	 Pool nya
// - Implementasi Pool di Go-Lang ini sudah aman dari problem race condition

// func getDataFromPool(group *sync.WaitGroup, pool *sync.Pool) {
func getDataFromPool(group *sync.WaitGroup, pool *sync.Pool) {
	defer group.Done()

	group.Add(1)
	data := pool.Get()
	fmt.Println(data)
	pool.Put(data)
}

func TestSyncPool(t *testing.T) {
	group := &sync.WaitGroup{}
	pool := sync.Pool{
		// override default value (nil)
		New: func() interface{} {
			return "Empty"
		},
	}

	pool.Put("Adnin")
	pool.Put("Rifandi")
	pool.Put("Sutanto")

	for i := 0; i < 10; i++ {
		go getDataFromPool(group, &pool)
	}

	group.Wait()
	fmt.Println("Selesai")
}

// # sync.Map
// - Go-Lang memiliki sebuah struct beranama sync.Map
// - Map ini mirip Go-Lang map, namun yang membedakan, Map ini aman
// 	 untuk menggunaan concurrent menggunakan goroutine
// - Ada beberapa function yang bisa kita gunakan di Map :
//   > Store(key, value) untuk menyimpan data ke Map
//   > Load(key) untuk mengambil data dari Map menggunakan key
//   > Delete(key) untuk menghapus data di Map menggunakan key
//   > Range(function(key, value)) digunakan untuk melakukan iterasi
// 	   seluruh data di Map

func TestSyncMap(t *testing.T) {
	group := sync.WaitGroup{}
	data := sync.Map{}

	addToMap := func(group *sync.WaitGroup, data *sync.Map, value int) {
		defer group.Done()
		group.Add(1)
		data.Store(value, value)
	}

	for i := 0; i < 100; i++ {
		go addToMap(&group, &data, i)
	}

	group.Wait()

	counter := 1
	data.Range(func(key, value interface{}) bool {
		fmt.Println("ke ", counter, ": ", key, " ", value)
		counter++
		return true
	})
}

// # sync.Cond
// - Cond adalah adalah implementasi locking berbasis kondisi.
// - Cond membutuhkan Locker (bisa menggunakan Mutex atau RWMutex) untuk
// 	 implementasi locking nya, namun berbeda dengan Locker biasanya, di
// 	 Cond terdapat function Wait() untuk menunggu apakah perlu menunggu
// 	 atau tidak
// - Function Signal() bisa digunakan untuk memberi tahu sebuah goroutine
// 	 agar tidak perlu menunggu lagi, sedangkan function Broadcast()
// 	 digunakan untuk memberi tahu semua goroutine agar tidak perlu
// 	 menunggu lagi
// - Untuk membuat Cond, kita bisa menggunakan function sync.NewCond(Locker)

var locker = sync.Mutex{}
var cond = sync.NewCond(&locker)
var group = sync.WaitGroup{}

func WaitCondition(value int) {
	defer group.Done()
	group.Add(1)

	cond.L.Lock()
	cond.Wait()
	fmt.Println("Done ", value)
	cond.L.Unlock()
}

func TestSyncCond(t *testing.T) {
	for i := 0; i < 10; i++ {
		go WaitCondition(i)
	}

	// single signal
	// go func() {
	// 	for i := 0; i < 10; i++ {
	// 		time.Sleep(1 * time.Second)
	// 		cond.Signal()
	// 	}
	// }()

	// broadcast
	go func() {
		time.Sleep(1 * time.Second)
		cond.Broadcast()
	}()

	group.Wait()
}
