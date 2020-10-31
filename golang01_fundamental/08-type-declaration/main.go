package main

import "fmt"

func main() {
	/** style 1 */
	type Name1 string
	type Age1 int16

	var name1 Name1 = "Adnin Rifandi Sutanto Putra"
	var age1 Age1 = 22

	fmt.Println(name1)
	fmt.Println(age1)

	/** style 2 */
	type (
		Name2 string
		Age2  int16
	)

	var name2 Name2 = "Adnin Rifandi Sutanto Putra"
	var age2 Age2 = 22

	fmt.Println(name2)
	fmt.Println(age2)

}
