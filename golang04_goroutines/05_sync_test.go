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
