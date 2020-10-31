package main

import (
	"container/list"
	"fmt"
)

/**
#Package container/list"
-	list ini adalah data seperti data array atau slice
	tapi mirip seperti fitur pagination pada halaman web
-	pada list, awal dan akhirnya berupa nil
-	list tidak bisa diakses menggunakan index

ex:
[nil,1,2,3,4,nil]
-	pointer saat ini misalkan ada di angka 1
-	next (2)
-	prev (1)
-	next (2)
- 	next (3) dst...

-----------------------------------------------------
|	method			|	description					|
-----------------------------------------------------
|	pushBack(value)	|	add data to right (next)	|
|	pushBack(value)	|	add data to left (prev)		|
-----------------------------------------------------
*/
func main() {
	dataList := list.New() // [nil, nil]
	dataList.PushBack(1)   // [nil, 1, nil]
	dataList.PushFront(0)  // [nil, 0, 1, nil]
	dataList.PushBack(2)   // [nil, 1, 2, nil]
	dataList.PushBack(3)   // [nil, 1, 2 , 3, nil]

	fmt.Println(dataList.Front().Value)                      // 0
	fmt.Println(dataList.Front().Next().Value)               // 1
	fmt.Println(dataList.Front().Next().Next().Value)        // 2
	fmt.Println(dataList.Front().Next().Next().Next().Value) // 3
	fmt.Println(dataList.Back().Value)                       // 3

	// iteration
	// front to back
	for element := dataList.Front(); element != nil; element = element.Next() {
		fmt.Println(element.Value)
	}

	// back to front
	for element := dataList.Front(); element != nil; element = element.Next() {
		fmt.Println(element.Value)
	}
}
