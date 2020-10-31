package main

import "fmt"

/**
#Nil#
Nil == Null

Nil supported by:
-	interface
-	function
-	map
-	slice
-	pointer
-	channel

*/
func main() {
	null := nilValue()
	if null == nil {
		fmt.Println("Value is Null")
	}
}

func nilValue() interface{} {
	return nil
}
