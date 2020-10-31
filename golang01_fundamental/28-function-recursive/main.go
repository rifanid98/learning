package main

import "fmt"

/**
#Function Revursive#
Function able to call self recursively

func functionName(paramName paramDataType) returnDataType {
	variableName := value
	functionName(variableName)
}

#Warning#
Be careaful to use recursive function, it will caused infinite
loop if you wrong to use it.
*/

func main() {
	number := 5
	total := factorialRecursive(number)
	fmt.Println(total)
}

func factorialRecursive(value int) int {
	fmt.Println(value)
	if value == 1 {
		return 1
	} else {
		return value * factorialRecursive(value-1)
	}
}
