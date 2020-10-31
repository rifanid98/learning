package main

import "fmt"

func main() {
	/** style 1 */
	counter := 1

	for counter <= 5 {
		fmt.Println("Loop ke", counter)
		counter++
	}

	/**
	style 2

	#for with statement#

	for i := 0; i < count; i++ {
		^^^^^^  ^^^^^^^^^  ^^^
		^^^^^^  ^^^^^^^^^  post statement
		^^^^^^  ^^^^^^^^^
		^^^^^^  check statement
		^^^^^^
		^^^^^^
		init statement

		// your code here
	}
	*/

	for i := 0; i <= 5; i++ {
		fmt.Println("Loop w/ statement ke", i)
	}

	/**
	style 3

	#for range#

	for _, var := range var {
		^^
		is mean, index variable not used
	}

	*/

	// for range with slice
	names := []string{"Adnin", "Rifandi", "Sutanto", "Putra"}
	for index, item := range names {
		fmt.Println("name :", item, "from", names, "at index", index)
	}

	// for range with map
	person := make(map[string]string)
	person["name"] = "Adnin"
	person["age"] = "22"

	for key, value := range person {
		fmt.Println("key", key, "value", value)
	}
}
