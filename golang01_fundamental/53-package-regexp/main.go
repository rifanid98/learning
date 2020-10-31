package main

import (
	"fmt"
	"regexp"
)

/**
#Package regexp#

---------------------------------------------------------------------------------
|	method								|	description							|
---------------------------------------------------------------------------------
|	regexp.MustCompile(string)			|	make new regexp						|
|	regexp.MatchString(string) bool		|	check is regexp match with string	|
|	regexp.FindAllString(string, max)	|	search string with maximum result	|
---------------------------------------------------------------------------------

*/
func main() {
	var regex *regexp.Regexp = regexp.MustCompile(`([a-z]{1,3})`)

	fmt.Println(regex.MatchString("adnin")) // false
	fmt.Println(regex.MatchString("adn"))   // true
	fmt.Println(regex.MatchString("Adn"))   // false

	fmt.Println(regex.FindAllString("adn Adn adnin ADNIN rif", 10))
}
