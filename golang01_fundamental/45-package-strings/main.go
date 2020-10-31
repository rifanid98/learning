package main

import (
	"fmt"
	"strings"
)

/**
#Package Strings#

-----------------------------------------------------------------------------------------------------
|	method									|	functionality										|
-----------------------------------------------------------------------------------------------------
|	strings.Trim(string, cutset)			|	Cuts the cutset at the start and end of the string	|
|	strings.ToLower(string)					|	Lowercase all character strings						|
|	strings.ToUpper(string)					|	Uppercase all character strings						|
|	strings.Split(string, separator)		|	Cutting strings based on the separator				|
|	strings.Contains(string, search)		|	Checks whether the string contains a string			|
|	strings.ReplaceAll(string, from, to)	|	Converts all strings from one string to another		|
-----------------------------------------------------------------------------------------------------

*/
func main() {
	var name string
	name = " Adnin Rifandi Sutanto Putra "
	fmt.Println(name) // " Adnin Rifandi Sutanto Putra"

	nameTrim := strings.Trim(name, " ")
	nameLower := strings.ToLower(name)
	nameUpper := strings.ToUpper(name)
	nameSplit := strings.Split(nameTrim, " ")
	nameContains := strings.Contains(name, "Adnin")
	nameReplaceAll := strings.ReplaceAll(name, "Adnin", "Rifandi")

	fmt.Println(nameTrim)       // "Adnin Rifandi Sutanto Putra"
	fmt.Println(nameLower)      // adnin rifandi sutanto putra
	fmt.Println(nameUpper)      // ADNIN RIFANDI SUTANTO PUTRA
	fmt.Println(nameSplit)      // [Adnin Rifandi Sutanto Putra]
	fmt.Println(nameSplit[0])   // Adnin
	fmt.Println(nameContains)   // true
	fmt.Println(nameReplaceAll) // Rifandi Rifandi Sutanto Putra
}
