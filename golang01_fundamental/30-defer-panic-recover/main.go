package main

import "fmt"

/**
#Defer#
- 	A defer function is a function that we can schedule
	to execute after a function has been executed,
	or simply "defer is the same as a callback".
-	The defer function will always be executed even
	if an error occurs in the function being executed.

ex:

func logging() {
	fmt.Println("executed")
}

func main() {
	defer logging()
	fmt.Println("Main function was executed")
}

output:
Main function was executed
excuted
*/

func main() {
	user := "Adnin"
	defer welcome(user)
	fmt.Println("Hello") // it will executed first

	panicError()
	panicError2()
	recoverPanic()
}

func welcome(user string) {
	fmt.Println("Welcome user", user) // then it will executed
}

/**
#Panic#
- 	Panic functions are functions that we can use
	to terminate the program
-	Panic functions are usually called when an error
	occurs while our program is running
-	The panic function property is called, the program
	will terminate, but the defer function will still
	be executed

ex:

func logging() {
	fmt.Println("executed")
}

func main() {
	defer logging()
	error := true
	if error {
		panic("Error!")
	}
}
*/

func panicError() {
	// uncomment to see the result

	// error := true
	// if error {
	// 	panic("Error!") // panic: Error!
	// }
}

/**
#Recover#
-	Recover is a function that we can use to capture panic data
-	With the recover process panic it will stop,
	so the program will continue to run
-	Panic errors will stop your code where the panic occurs.
	but with recover, after panic occurs, code outside the scope
	panic will still be executed

ex:

func recover() {
	message := recover()
	fmt.Println("An error was occured", message)
}

func main() {
	defer recover()
	error := true
	if error {
		panic("Panic Error!")
	}
}
*/

func panicError2() {
	// uncomment to see the result
	defer recoverPanic()
	error := true
	if error {
		panic("Error!") // panic: Error!
	}
}

func recoverPanic() {
	message := recover()
	fmt.Println("An error was occured", message)
}
