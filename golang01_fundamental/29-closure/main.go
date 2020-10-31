package main

import "fmt"

/**
closure. Scopes that are outside the function can be accessed
from inside the function. However, the scope inside the function
cannot be accessed from outside the function

ex:

func closure() {
	name := "Adnin"
	fmt.Println(name) 		// Adnin
	newName := func() {
		name = "Rifandi" =>	// it will replace name on outside this
		age := 22			// anonymous function when this function
	}						// created for the first time

	newName()
	fmt.Println(name)		// Rifandi

	// But you cannot access
	// variable inside the function
	fmt.Println(age)		// error
}

But if you declare new variable with
same name, it will create new variable
for you

func closure() {
	name := "Adnin"
	fmt.Println(name) 		// Adnin
	newName := func() {
		name := "Rifandi" =>
		age := 22
		fmt.Println(name)		// Rifandi
	}

	newName()
	fmt.Println(name)		// Adnin

	// But you cannot access
	// variable inside the function
	fmt.Println(age)		// error
}
*/

func main() {
	var name string = "Adnin"
	var age int16 = 22
	fmt.Println(name) // Adnin
	setName := func() {
		name = "Rifandi" // update the name
		age := 23
		fmt.Println(age) // 23
	}

	setName()
	fmt.Println(age)  // 22
	fmt.Println(name) // Rifandi
}
