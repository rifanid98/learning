package main

import (
	"fmt"
	"os"
)

/**
#Package OS#

ex:
import "os"

func main() {
	args := os.Args
	fmt.Println(args)
	fmt.Println(0)	// path of compiled binary file
	fmt.Println(1)	// Adnin
	fmt.Println(2)	// Rifandi
}

use:
go run filename.go Adnin Rifandi
*/
func main() {
	// use: go run filename.go Adnin Rifandi
	// packageOSArguments()

	// use: go run filename.go
	// packageOSHostname()

	// set environment first
	//
	// export MY_USERNAME=username
	// export MY_PASSWORD=password
	//
	// use: go run filename.go
	// packageOSGetenv()
}

func packageOSArguments() {
	args := os.Args
	fmt.Println(args)
	fmt.Println(0) // path of compiled binary file
	fmt.Println(1) // Adnin
	fmt.Println(2) // Rifandi
}

func packageOSHostname() {
	name, err := os.Hostname()
	if err == nil {
		fmt.Println("Hostname ", name)
	} else {
		fmt.Println("Error:", err.Error())
	}
}

func packageOSGetenv() {
	username := os.Getenv("MY_USERNAME")
	password := os.Getenv("MY_PASSWORD")

	fmt.Println(username)
	fmt.Println(password)
}
