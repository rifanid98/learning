package main

import "fmt"

func main() {
	/**
	#If Expression#

	if value1 [operator] value2 {
		// your code here
	}

	ex:

	var name = "John"
	if name == "John" {
		fmt.Println("Welcome John :)")
	}
	*/

	var name string = "Adnin"
	var matkul = "TI"
	nilai := 80

	if name == "Adnin" {
		if matkul == "TI" && nilai >= 80 {
			fmt.Println("Adnin Lulus")
		} else if matkul == "TI" && nilai < 80 {
			fmt.Println("Adnin Tidak Lulus")
		}
	} else {
		fmt.Println("Bukan Adnin")
	}

	/**
	#If Short Hand#

	if statement; argument {
		// your code here
	}

	ex:

	if name := "Adnin"; len(name) >= 5 {
		fmt.Println("Name is good")
	}
	*/

	if name := "Adnin"; len(name) >= 5 {
		fmt.Println("Name is good")
	}
}
