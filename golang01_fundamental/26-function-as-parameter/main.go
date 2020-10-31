package main

import "fmt"

/**
#Theory#

// style 1
func functionName(variableName variableDataType, variableName func(paramDataType) returnDataType) returnDataType {
	var status string
	status = "Hai " + name + ". " + name + " is " + selection(name)
	return status
}

// style 2
type FunctionAsParameter func(paramDataType) returnDataType
func functionName(variableName variableDataType, variableName FunctionAsParameter) returnDataType {
	var status string
	status = "Hai " + name + ". " + name + " is " + selection(name)
	return status
}
*/


func main()  {
	name := "Adnin"
	fmt.Println(sayHello(name, nameSelection))
}

func sayHello(name string, selection func(string) string) string {
	var status string
	status = "Hai " + name + ". " + name + " is " + selection(name)
	return status
}

func nameSelection(name string) string {
	var status string

	switch name {
	case "Adnin":
		status = "single"
		break
	
	case "Rifandi":
		status = "double"
		break

	default:
		break
	}

	return status
}