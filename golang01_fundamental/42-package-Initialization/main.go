package main

import "fmt"

/**
#Package Initialization#
Package Initialization is like constructor in OOP language

ex:

func init() {
	// this code is a constructor
	// this function will executed when package
	// loaded or imported
}

#Blank Identifier#
Use this if you want to execute init() or constructor of the package
without executing other function insinde it.

ex:

import _ "directory-to-the/package"
// _ is blank identifier

*/

func init() {
	fmt.Println("Constructor executed!")
	// init() or constructor will executed first
}

func main() {
	fmt.Println("This package loaded!")
	// main() will executed after init()
}
