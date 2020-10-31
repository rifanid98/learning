package main

import "fmt"

/**
#Anonymous Function#

// style 1
variableName := func(paramName paramDataType) returnDataType {
	// your code here
}

// style 2
// param as parameter is an anonymous function

*/

func main()  {
	selection := func(name string) bool {
		if name == "Adnin" {
			return true
		} else {
			return false
		}
	}

	name := "Adnin"
	fmt.Println("Is Adnin ? ", selection(name))
	
}