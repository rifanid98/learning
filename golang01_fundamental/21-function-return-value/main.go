package main

import "fmt"

func main() {
	name := "Adnin"
	sayHello := hello(name)
	fmt.Println(sayHello)
}

/**
func functionName(paramName paramDataType) returnDataType {
	return value
	// your code here
}
*/

func hello(name string) string {
	hello := "Hello " + name
	return hello
}
