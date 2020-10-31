package main

import "fmt"

func main() {
	/**
	var variableName = value

	switch variableName {
	case argument:
		// your code here

	default:
		// your code here
	}
	*/
	name := "Adnin"

	switch name {
	case "Adnin":
		fmt.Println("Name is", name)

	case "Rifandi":
		fmt.Println("Rifandi Sutanto")

	default:
		fmt.Println("Undefined")
	}

	/**
	#switch without condition#
	name := "Adnin"
	var nameLength = len(name)

	switch {
	case length > 10:
		fmt.Println("Too long")

	case length < 5:
		fmt.Println("Too short")

	default:
		fmt.Println("Name could not to be empty")
	}
	*/

	// name := "Adnin"
	var nameLength = len(name)

	switch {
	case nameLength > 10:
		fmt.Println("Too long")

	case nameLength < 5:
		fmt.Println("Too short")

	default:
		fmt.Println("Name could not to be empty")
	}

	/**
	#you can add break in switch#

	name := "Adnin"
	var nameLength = len(name)

	switch {
	case length > 10:
		fmt.Println("Too long")
		break

	case length < 5:
		fmt.Println("Too short")
		break

	default:
		fmt.Println("Name could not to be empty")
		break
	}
	*/
}
