package main

import "fmt"

/**
#Struct Method#
Struct method is like method in class.
but not exactly like that.

ex:

type StructName struct {
	VariableName1, VariableName2 dataType
	VariableName3 dataType
	....
}

func main() {
	// your code here
	variableName := StructName{
		variableName1: value1,
		variableName2: value2,
		variableName3: value3,
	}
	variableName.sayHello() // now, StructName have a method
}
func (structName StructName) sayHello() {
	// your code here
}

*/

func main() {
	student()
}

// Person struct
type Person struct {
	Name, Address string
	Age           int
}

func student() {
	adnin := Person{
		Name:    "Adnin",
		Address: "Kp. Sinagar",
		Age:     22,
	}
	// introduce
	adnin.introduce()
}

func (student Person) introduce() {
	fmt.Println("Hello, my name is", student.Name)
	fmt.Println("I'm", student.Age, "years old")
	fmt.Println("And i'm live at", student.Address)
}
