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
func functionName(paramName paramDataType) (namedReturn returnDataType1, namedReturn returnDataType2) {
	// your code here
	// return -> will return all value
	return value1, value2
}
*/

func hello(name string, age int) (hello string, umur int) {
	say := "Hello " + name
	return say, age
}
