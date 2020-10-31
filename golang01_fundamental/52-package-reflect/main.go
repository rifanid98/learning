package main

import (
	"fmt"
	"reflect"
)

/**
#Package reflect#
*/

// User Struct
type User struct {
	Name string `required:"true" max:"10"`
	Age  int
}

func main() {
	name := "Adnin"
	age := 22
	fmt.Println(reflect.TypeOf(name))
	fmt.Println(reflect.TypeOf(age))

	user := User{"Adnin", 22}
	userType := reflect.TypeOf(user)
	userFields := userType.NumField()
	userField := userType.Field(0)
	fmt.Println(userFields)
	fmt.Println(userField.Name)

	/**
	#StructTag#
	Struct with tag options

	ex:
	type StructName struct {
		VariableName1 dataType `tagName:"tagValue" tagName2:"tagValue2"`
		VariableName2 dataType
	}
	*/
	required := userField.Tag.Get("required")
	max := userField.Tag.Get("max")
	fmt.Println(required)
	fmt.Println(max)
}
