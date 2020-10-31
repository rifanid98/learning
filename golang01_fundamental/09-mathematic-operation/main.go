package main

import "fmt"

func main() {
	/**
	#Supported Mathematic Operation#
	> +
	> -
	> *
	> /
	> %

	ex: | normal version |  augmented assignments version  |
		----------------------------------------------------
		| a = a + 1  	 |	a += 1 						   |
	    | a = a - 1		 |  a -= 1 						   |
	    | a = a * 1		 |  a *= 1 						   |
	    | a = a / 1		 |  a /= 1 						   |
		| a = a % 1		 |  a %= 1 						   |

		| unary operator								  			  				|
		-----------------------------------------------------------------------------
		| ++	=>	a = a + 1	ex: var i = 1, i++, i is 2						   	|
		| --	=>	a = a - 1	ex: var i = 1, i--, i is 0				   			|
		| -		=>	Negative	ex: var i = 1, -i, i is -1 (will be printed as -1)	|
		| +  	=>	Positive	ex: var i = 1, +i, i is +1 (will be printed as 1)	|
		| ! 	=>	the opposite of a value	(!true is equal to false) 				|

	*/

	/** style 1 */
	var a1 int16
	var b1 int16
	var c1 int16

	fmt.Println("style 1")
	fmt.Println("=======")
	fmt.Println("var a1 int16")
	fmt.Println("var b1 int16")
	fmt.Println("var c1 int16")

	a1 = 1
	b1 = 2
	c1 = a1 + b1

	fmt.Println("")

	fmt.Println("a1 = 1 ")
	fmt.Println("b1 = 2 ")
	fmt.Println("c1 = a1 + b1 ")
	fmt.Println("result = ", c1)

	/** style 2 */
	var a2 = 1
	var b2 = 2
	var c2 = a2 + b2

	fmt.Println("")

	fmt.Println("style 2")
	fmt.Println("=======")
	fmt.Println("var a2 = 1")
	fmt.Println("var b2 = 2")
	fmt.Println("var c2 = a2 + b2")
	fmt.Println("result ", c2)

	// or
	// var(
	// 	a2 = 1
	// 	b2 = 2
	// 	c2 = a2 + b2
	// )

	fmt.Println("")

	/** style 3 */
	a3 := 1
	b3 := 2
	c3 := a3 + b3

	fmt.Println("style 3")
	fmt.Println("=======")
	fmt.Println("a3 := 1")
	fmt.Println("b3 := 2")
	fmt.Println("c3 := a3 + b3")
	fmt.Println("result ", c3)
}
