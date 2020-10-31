package main

import "fmt"

func main() {
	// use variadic function
	// style 1
	age := variadicFunction(10, 22, 21, 19)
	fmt.Println("Total age", age) // Total age 72

	// style 2
	ages := []int{10, 22, 21, 19}
	fmt.Println("Total age", variadicFunction(ages...)) // Total age 72
}

/**
#Variadic Function#
function using one paramater
with multiple values

func functionName(paramName ...dataType) returnDataType {
	total := 0
	for _, age := range ages {
		total += age
	}
	return total
}
*/

func variadicFunction(ages ...int) int {
	total := 0
	for _, age := range ages {
		total += age
	}
	return total
}
