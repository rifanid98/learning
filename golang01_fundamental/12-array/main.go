package main

import "fmt"

func main() {
	/**
	The array that has been created cannot be filled
	more than the number of values defined

	array["adnin","rifandi","sutanto","putra"]

	|	index	|	data				|
	-------------------------------------
	|	0		|	adnin				|
	|	1		|	rifandi				|
	|	2		|	sutanto				|
	|	3		|	putra				|
	|	4		|	error: not exists	|
	*/

	/** style 1 */
	var names [4]string
	names[0] = "adnin"
	names[1] = "rifandi"
	names[2] = "sutanto"
	names[3] = "putra"

	fmt.Println("names[0] = ", names[0])
	fmt.Println("names[1] = ", names[1])
	fmt.Println("names[2] = ", names[2])
	fmt.Println("names[3] = ", names[3])

	/** style 2 */
	var names2 = [4]string{"adnin", "rifandi", "sutanto", "putra"}
	fmt.Println("fmt.Println(names2)", names2)
	fmt.Println("names2[0] = ", names2[0])
	fmt.Println("names2[1] = ", names2[1])
	fmt.Println("names2[2] = ", names2[2])
	fmt.Println("names2[3] = ", names2[3])

	/**
	Array functions

	|	operation				|	description									|
	-----------------------------------------------------------------------------
	|	len(array)				|	get length of array							|
	|	array[index]			|	get array value by index of array element	|
	|	array[index] = value	|	assign value to element of array at index	|
	*/

	fmt.Println("length of names", len(names))
	fmt.Println("length of names2", len(names2))

	var testArray [10]string
	fmt.Println("length of declarated array but not assigned yet", len(testArray))

}
