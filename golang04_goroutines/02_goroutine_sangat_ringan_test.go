package golang04_goroutines

import (
	"fmt"
	"testing"
	"time"
)

func DisplayNumber(number int) {
	fmt.Println("Display ", number)
}

func TestManyGoroutine(t *testing.T) {
	for i := 0; i < 100_000; i++ {
		go DisplayNumber(i)
	}

	time.Sleep(5 * time.Second)
}
