package main

import "fmt"

/**
#Struct#
Struct is template data
Equivalent of Struct is Object (in javascript)
*/

func main() {
	normalStruct()
	literalsStruct()
}

/**
#Normal Struct#

ex:

type StructName struct {
	VariableName1, VariableName2 dataType
	VariableName3 dataType
	....
}

#StructTag#
Struct with tag options

ex:
type StructName struct {
	VariableName1 dataType `tagName:"tagValue" tagName2:"tagValue2"`
	VariableName2 dataType
}

use:
see at 52-package-reflect/main.go file
*/

// Person struct
type Person struct {
	Name, Address string
	Age           int
	Married       bool
}

func normalStruct() {
	var adnin Person
	adnin.Name = "Adnin"
	adnin.Address = "Kp. Sinagar"
	adnin.Age = 22
	adnin.Married = false

	// print all element in struct
	fmt.Println(adnin)

	// print each of struct element
	fmt.Println(adnin.Name)
	fmt.Println(adnin.Address)
	fmt.Println(adnin.Age)
	fmt.Println(adnin.Married)
}

/**
#Literals Struct#
-	Literals Struct is struct declared like
	an anonymous function.
-	In JavaScript, literals function is how
	we define an Object.

ex:

type StructName struct {
	VariableName1, VariableName2 dataType
	VariableName3 dataType
	....
}

func literalsStruct() {
	// style 1
	myStruct := StructName{
		VariableName1: "Value1",
		VariableName2: "Value2",
		VariableName3: "Value3",
	}

	// style 2
	myStruct2 := StructName{"value1","value2","value3"}

	// note:
	// if you use style 2, will caused error when you
	// change structur of struct type
}
*/

// Student struct
type Student struct {
	Name, Address string
	Age           int
	Married       bool
}

func literalsStruct() {
	adnin := Student{
		Name:    "Adnin",
		Address: "Kp. Sinagar",
		Age:     22,
		Married: false,
	}
	fmt.Println(adnin)

	rifandi := Student{"Rifandi", "Kp. Cibanteng", 22, false}
	fmt.Println(rifandi)
}
