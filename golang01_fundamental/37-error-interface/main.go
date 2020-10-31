package main

import (
	"errors"
	"fmt"
)

/**
#Error Interface#

type error interface {
	Error() string
}

ex:
func main() {
	var contohError error = errors.New("Ups Error")
	fmt.Println(contohError.Error())
}

*/
func main() {
	hasil, error := divider(100, 10)
	// hasil, error := divider(100, 0) // Error pembagi tidak boleh 0
	if error == nil {
		fmt.Println("Hasil", hasil)
	} else {
		fmt.Println("Error", error)
	}
}

func divider(nilai int, pembagi int) (int, error) {
	if pembagi == 0 {
		return 0, errors.New("Pembagi tidak boleh 0")
	}

	hasil := nilai / pembagi
	return hasil, nil
}
