package main

import "fmt"

func main() {
	/** break */
	for i := 0; i <= 5; i++ {
		if i == 4 {
			fmt.Println("Loop ke 4, akan dihentikan")
			break
		}

		fmt.Println("Loop ke", i)
	}

	/** continue */
	for i := 0; i <= 10; i++ {
		if i%2 == 0 {
			fmt.Println("Angka genap, next!.")
			continue
		}

		if i == 7 {
			fmt.Println("Angka 7, akan dihentikan")
			break
		}

		fmt.Println("Loop ke", i)
	}
}
