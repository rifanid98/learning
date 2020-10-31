package main

import "fmt"

func main() {
	name := "Adnin"
	age := 22
	hello, umur := hello(name, age)
	// _, umur := hello(name, age)
	// _ -> hello returned value not used
	fmt.Println(hello, "umurmu", umur)
}

/**
func functionName(paramName paramDataType) (returnDataType1, returnDataType2) {
	return value1, value2
	// your code here
}
*/

func hello(name string, age int) (string, int) {
	hello := "Hello " + name
	return hello, age
}
