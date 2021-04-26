package helper

import (
	"runtime"
	"testing"
)

// # Skip Test
// - Kadang dalam keadaan tertentu, kita ingin membatalkan eksekusi unit test
// - Di Go-Lang juga kita bisa membatalkan eksekusi unit test jika kita mau
// - Untuk membatalkan unit test kita bisa menggunakan function Skip()

func TestSkip(t *testing.T) {
	if runtime.GOOS != "darwin" {
		t.Skip("cannot be run on the operating system other than Mac OS")
	}
}
