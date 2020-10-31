package main

import "fmt"

/**
#Type Assertions#

-	Type Assertions is the ability to change data types to other desired data types.
-	This feature is often used when encountering empty data interfaces.
-	Change dataType interface{} to string, int etc.
-	Be careful to use Type Assertions. If Type Assertions you do is not match with
	returnDataType of interface{}, it will causing panic error on your code.

ex:
func functionName() interface{} {
	return "Value" // string
}

func main() {
	result := functionName()
	resultString := result.(string) // change interface{} into string dataType
}
*/
func main() {
	// style 1
	myInterface := interfaceToString()
	myStringInterface := myInterface.(string)
	fmt.Println(myStringInterface)

	// style 2
	myInterface2 := interfaceToString()
	switch myStringInterface2 := myInterface2.(type) {
	case string:
		fmt.Println(myStringInterface2)
		break

	default:
		fmt.Println("unknown data type")
		break
	}
}

func interfaceToString() interface{} {
	return "string value"
}
