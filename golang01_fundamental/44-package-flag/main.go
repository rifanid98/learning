package main

import (
	"flag"
	"fmt"
)

/**
#Package Flag#
Package Flag is used to parse command line argument

ex:
import "flag"

func main() {
	username := flag.String("username","root","you must insert username")
						  // ^^^^^^^^   ^^^^   ^^^^^^^^^^^^^^^^^^^^^^^^ description info of argument
						  // ^^^^^^^^   ^^^^
						  // ^^^^^^^^   ^^^^ default value of argument
						  // ^^^^^^^^
						  // ^^^^^^^^ name of argument
	flag.Parse()

	fmt.Println(*username) // you must use pointer.
}
*/
func main() {
	// use : go run filename.go -host=value -username=value -password=value
	// packageFlagString()
}

func packageFlagString() {
	host := flag.String("host", "localhost", "hostname of your os")
	username := flag.String("username", "root", "username of your os")
	password := flag.String("password", "root", "password of your os")

	flag.Parse()
	fmt.Println(*host, *username, *password)
}
