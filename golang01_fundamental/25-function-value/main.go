package main

import "fmt"

func main()  {
	/** function as value */
	hello := sayHello
	name := "Adnin"
	fmt.Println(hello(name))
}

func sayHello(name string) string {
	hello := "Hello " + name
	return hello
}