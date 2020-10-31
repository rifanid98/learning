package main

import (
	"fmt"
	"strconv"
)

/**
#Package strconv#
String Convertion

-------------------------------------------------------------------------------------
|	method											|	functionality				|
-------------------------------------------------------------------------------------
|	strconv.parseBool(string)						|	Converts string to bool		|
|	strconv.parseFloat(string, byteType)			|	Converts string to float	|
|	strconv.parseInt(string, formatType, byteType)	|	Converts string to int64	|
|	strconv.FormatBool(bool)						|	Converts bool to string		|
|	strconv.FormatFloat(float,...)					|	Converts float64 to string	|
|	strconv.FormatInt(int,...)						|	Converts int64 to string	|
|	strconv.FormatInt(int,...)						|	Converts int64 to string	|
|	strconv.Atoi(string)							|	Converts string to int		|
|	strconv.Itoa(int)								|	Converts int to string		|
-------------------------------------------------------------------------------------

*/
func main() {
	stringToBool()
	stringToFloat()
	stringToInt()
	formatToBool()
	// formatToFloat()
	// formatToInt()
	formatAtoi()
	formatItoa()
}

func stringToBool() {
	boolString := "true"
	res, err := strconv.ParseBool(boolString)
	if err == nil {
		fmt.Println(res)
	} else {
		fmt.Println("Error: ", err)
	}
}

func stringToFloat() {
	intString := "99.9"
	res, err := strconv.ParseFloat(intString, 16)
	// strconv.ParseFloat(intString, 16)
	// strconv.ParseFloat(string, int16)
	// 2 = biner, 8 = octal, 10 = decimal

	if err == nil {
		fmt.Println(res)
	} else {
		fmt.Println("Error: ", err)
	}
}

func stringToInt() {
	intString := "100"
	res, err := strconv.ParseInt(intString, 10, 16)
	// strconv.ParseInt(intString, 2, 16)
	// strconv.ParseInt(string, decimal, int16)
	// 2 = biner, 8 = octal, 10 = decimal

	if err == nil {
		fmt.Println(res)
	} else {
		fmt.Println("Error: ", err)
	}
}

func formatToBool() {
	boolean := true
	res := strconv.FormatBool(boolean)
	fmt.Println(res)
}

// func formatToFloat() {
// 	floatNumber := 99.9
// 	res := strconv.FormatFloat(floatNumber, 10, )
// 	// strconv.FormatFloat(floatNumber, 16)
// 	// strconv.FormatFloat(string, int16)
// 	// 2 = biner, 8 = octal, 10 = decimal

// 	if err == nil {
// 		fmt.Println(res)
// 	} else {
// 		fmt.Println("Error: ", err)
// 	}
// }

// func formatToInt() {
// 	intString := "100"
// 	res, err := strconv.FormatInt(intString, 10, 16)
// 	// strconv.FormatInt(intString, 2, 16)
// 	// strconv.FormatInt(string, decimal, int16)
// 	// 2 = biner, 8 = octal, 10 = decimal

// 	if err == nil {
// 		fmt.Println(res)
// 	} else {
// 		fmt.Println("Error: ", err)
// 	}
// }

func formatAtoi() {
	intString := "100"
	res, err := strconv.Atoi(intString)
	if err == nil {
		fmt.Println(res)
	} else {
		fmt.Println("Error: ", err)
	}
}

func formatItoa() {
	intNumber := 100
	res := strconv.Itoa(intNumber)
	fmt.Println(res)
}
