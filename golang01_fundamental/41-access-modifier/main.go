package main

/**
#Access Modifier#
-	Public : First letter of variable name or function name must be in uppercase
-	Private: First letter of variable name or function name must be in lowercase

ex:

package main

import "fmt"

var privateProperty string	// cannot be accessed from outside this package
var PublicProperty	string	// can be accessed from otside this package

func main() {
	// your code here
}

func privateFunction() {
	// this function is private
}

func PublicFunction() {
	// this function is public
}

*/

var privateProperty string

// PublicProperty property
var PublicProperty string

func main() {
	privateFunction()
	PublicFunction()
}

func privateFunction() bool {
	return false
}

// PublicFunction method
func PublicFunction() bool {
	return true
}
