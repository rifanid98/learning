package main

import "fmt"

/**
#Empty Interface#
Empty Interface is like any (return type in TypeScript) :

// TypeScript
function getData() any {
	// your code here
}

ex:

func functionName() interface{} {
	return value // value can be int, string, array, slice etc.
}

func main() {
	result := functionName()
	// var result string = functionName()
	// will caused error, because string is
	// not matched with interface{}. Because
	// interface{} is no dataType, dataType of
	// interface{} is dynamic
}

*/

func main() {
	name := "Adnin"
	hello := sayHello(name)                 // style 1
	var hello2 interface{} = sayHello(name) // style 2
	fmt.Println(hello)
	fmt.Println(hello2)
}

func sayHello(name string) interface{} {
	return "Hello " + name
}
