package main

import "fmt"

func main() {
	/**
	#Map#

	// style 1
	var example1 map[keyDataType]valueDataType = map[keyDataType]valueDataType{
		"key": "value",
		"key2": "value2", // coma is a must
	}

	example2 := map[keyDataType]valueDataType{
		"key": "value",
		"key2": "value2", // coma is a must
	}

	// assign new element (key, value)
	example1["key3"] = "value3"
	example2["key3"] = "value3"

	// call value by key
	fmt.Println(example1["key"]) // value

	*/

	/** style 1 */
	var person1 map[string]string = map[string]string{
		"name": "Adnin Rifandi Sutanto Putra",
		"job":  "Programmer",
	}
	person1["salary"] = "5.000K"
	fmt.Println("person1", person1)

	/** style 2 */
	person2 := map[string]string{
		"name": "Adnin Rifandi Sutanto Putra",
		"job":  "Fullstack Programmer",
	}

	fmt.Println("person2", person2)
	fmt.Println("person2 job", person2["job"])

	/**
	#Map Functions#

	-----------------------------------------------------------------------------
	|	operation							|	description						|
	-----------------------------------------------------------------------------
	|	len(map)							|	get length (total data) of map	|
	|	map[key]							|	get map data by key				|
	|	map[key] = value					|	assign value to key of map		|
	|	make(								|	make new map					|
	|		map[keyDataType]valueDataType	|									|
	|	)									|									|
	|	delete(map, key)					|	delete map element by key 		|
	-----------------------------------------------------------------------------
	*/

	/** len(map) */
	var personLength int16 = int16(len(person1))
	fmt.Println(personLength) // 3

	/** len(map) */
	var personName string = person1["name"]
	fmt.Println(personName) // Adnin Rifandi Sutanto Putra

	/** map[key] = value */
	var newName string = "Adnin Rifandi"
	person1["name"] = newName
	person1["job"] = "Fullstack Mobile Developer"
	fmt.Println(person1) // map[job:Fullstack Mobile Developer name:Adnin Rifandi salary:5.000K]

	/** make(map[keyDataType]valueDataType) */
	var bookMap map[string]string = make(map[string]string)
	bookMap["title"] = "Fullstack Mobile Developer"
	bookMap["pages"] = "200"
	fmt.Println(bookMap) // map[pages:200 title:Fullstack Mobile Developer]

	/** delet(map, key) */
	delete(bookMap, "pages")
	fmt.Println(bookMap) // map[title:Fullstack Mobile Developer]
}
