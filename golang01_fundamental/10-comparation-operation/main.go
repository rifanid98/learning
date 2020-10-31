package main

import "fmt"

func main() {
	var (
		nama1 = "Adnin"
		nama2 = "Rifandi"

		// number1 = 1
		// number2 = "1"

		number1 = 100
		number2 = 200
	)

	fmt.Println("nama1 == nama2 is ", nama1 == nama2)

	// fmt.Println(number1 == number2) => error

	fmt.Println("nama1 >  nama2 is ", nama1 > nama2)
	// true
	// sequentially in attendance, Adnin was earlier than Rifandi

	fmt.Println("number1 >  number2 is ", number1 > number2)  // true
	fmt.Println("number1 <  number2 is ", number1 < number2)  // false
	fmt.Println("number1 == number2 is ", number1 == number2) // false
	fmt.Println("number1 != number2 is ", number1 != number2) // true

}
