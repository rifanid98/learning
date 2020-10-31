package main

import "fmt"

func main() {
	/**
	#Number Conversion#

	Note:
	to converting value to other data type,
	the value must be smaller than the previous data type.

	You can convert variable values from low to high,
	but not vice versa.

	If the value of the variable that is converted
	to a lower data type, while the value of the variable
	is greater than the data type used,
	then the variable value will reverse from minus again

	ex:
	var nilai32 int32 = 128
	var nilai8 int8   = int8(nilai32)
	    ^^^^^^ nilai8 still able to handle the value 128

	var nilai32 int32 = 129
	var nilai8 int8   = int8(nilai32)
		^^^^^^ nilai8 can not handle the value 129
		can no longer handle the value 128,
		and will loop back to the value -128 (range value of int8 is -128 ~ 128)
	*/

	/** style 1 */
	var nilai32_1 int32 = 32764
	var nilai64_1 int64 = int64(nilai32_1)
	var nilai16_1 int16 = int16(nilai32_1)

	/** style 2 */
	nilai32_2 := 32764
	nilai64_2 := int64(nilai32_2)
	nilai16_2 := int16(nilai32_2)

	fmt.Println("style 1")
	fmt.Println("========")
	fmt.Println("var nilai32_1 int32 = 32764 ", nilai32_1)
	fmt.Println("var nilai64_1 int64 = int64(nilai32_1) ", nilai64_1)
	fmt.Println("var nilai16_1 int16 = int16(nilai32_1) ", nilai16_1)

	fmt.Println("")

	fmt.Println("style 2")
	fmt.Println("========")
	fmt.Println("nilai32_2 := 32764 ", nilai32_2)
	fmt.Println("nilai64_2 := int64(nilai32_2) ", nilai64_2)
	fmt.Println("nilai16_2 := int16(nilai32_2) ", nilai16_2)

	/**
	#String Conversion#

	*/
	var name string = "GoLang"
	var elementOfString byte = name[0] // get first element of string "GoLang"
	// and convert it to byte data type
	var convertedByteIntoPlainString string = string(elementOfString) // convert byte data type into string

	fmt.Println("string = ", name)
	fmt.Println("convert into byte (ASCII code) = ", elementOfString)
	fmt.Println("convert byte into string = ", convertedByteIntoPlainString)
}
