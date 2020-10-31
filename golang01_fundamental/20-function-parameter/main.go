package main

import "fmt"

func main() {
	name := "Adnin"
	hello(name)
}

/**
func functionName(paramName paramDataType) {
	// your code here
}
*/

func hello(name string) {
	hello := "Hello " + name
	fmt.Println(hello)
}
