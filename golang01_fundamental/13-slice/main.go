package main

import "fmt"

func main() {
	/**
	#Slice Functions#

	-------------------------------------------------------------------------------------
	|	function					|	description										|
	-------------------------------------------------------------------------------------
	|	len(slice)					|	get length of sliced array						|
	|	cap(slice)					|	get capacity of sliced array					|
	|	append(slice, data)			|	make new slice + add new data to end of slice	|
	|								|	if capacity is full, then will create new array	|
	|	make(						|	make new slice									|
	|		[]dataType, 			|													|
	|		length[number], 		|													|
	|		capacity[number]		|													|
	|	)							|													|
	|	copy(destination, source)	|	copy sliced array from source (source of 		|
	|								|	sliced array) to new destination variable		|
	-------------------------------------------------------------------------------------

	*/

	var months = [12]string{
		"januari",
		"februari",
		"maret",
		"april",
		"mei",
		"juni",
		"juli",
		"agustus",
		"september",
		"oktober",
		"november",
		"desember",
	}

	/**
	#Theory#

	var myArray = [n]dataType{n1,n2,n3,...,nLast}	// n1 is firstIndex
													// nLast is lastIndex
													// {1,2,3,...10} 10 is lastIndex
	var mySlice = myArray[lowIndex:highIndex]	// make slice from lowIndex to highIndex-1
	var mySlice = myArray[lowIndex:]			// make slice from lowIndex to lastIndex
	var mySlice = myArray[:highIndex]			// make slice from firstIndex to highIndex-1
	var mySlice = myArray[:]					// make slice from firstIndex to lastIndex
												// (like copy, look at #Slice Functions#)

	pointer		= lowIndex
	length		= lowIndex - (highIndex-1)
	capacity	= lowIndex ~ lastIndex

	ex:
	var myArray = [10]number{1,2,3,4,5,6,7,8,9,10}
							   0,1,2,3,4,5,6,7,8,9 -> index of myArray
	var mySlice = myArray[5:8] // 5,6,7

	low			= 5
	high		= 8
	pointer		= 5
	length		= 5 ~ (8-1)
				= 5 ~ 7
				= 5,6,7
				= 3 elements
	capacity	= 5 ~ 9
				= 5,6,7,8,9
				= 5 elements
	*/

	fmt.Println("- Slice - ")
	fmt.Println("")
	var slice1 = months[4:7]
	fmt.Println("var slice1 = months[4:7]")
	fmt.Println("low	 = 4")
	fmt.Println("high	 = 7")
	fmt.Println("pointer  = 4 ", slice1[0])
	fmt.Println("length	 =", len(slice1), "elements", slice1)
	fmt.Println("capacity =", cap(slice1), "elements", months[4:])

	fmt.Println("")

	var slice2 = months[6:9]
	fmt.Println("var slice2 = months[6:9]")
	fmt.Println("low	 = 6")
	fmt.Println("high	 = 9")
	fmt.Println("pointer  = 6 ", slice2[0])
	fmt.Println("length	 =", len(slice2), "elements", slice2)
	fmt.Println("capacity =", cap(slice2), "elements", months[6:])

	fmt.Println("")

	var slice3 = months[6:]
	fmt.Println("var slice3 = months[6:]")
	fmt.Println("low	 = 6")
	fmt.Println("high	 = 11 (lastIndex)")
	fmt.Println("pointer  = 6 ", slice3[0])
	fmt.Println("length	 =", len(slice3), "elements", slice3)
	fmt.Println("capacity =", cap(slice3), "elements", months[6:])

	fmt.Println("")

	var slice4 = months[:9]
	fmt.Println("var slice4 = months[:9]")
	fmt.Println("low	 = 0 (firstIndex)")
	fmt.Println("high	 = 9")
	fmt.Println("pointer  = 0", slice4[0], "(firstIndex)")
	fmt.Println("length	 =", len(slice4), "elements", slice4)
	fmt.Println("capacity =", cap(slice4), "elements", months[:9])

	fmt.Println("")

	var slice5 = months[:]
	fmt.Println("var slice5 = months[:]")
	fmt.Println("low	 = 0 (firstIndex)")
	fmt.Println("high	 = 11 (lastIndex)")
	fmt.Println("pointer  = 0", slice5[0], "(firstIndex)")
	fmt.Println("length	 =", len(slice5), "elements", slice5)
	fmt.Println("capacity =", cap(slice5), "elements", months[:])

	fmt.Println("")

	/**
	#Warning!#

	Source of slice (array) and slice (Sliced Array) is connected by pointer!
	-	if you change value of array that source of slice, value in slice will changed
	-	if you change value of sliced array, value in array that source of slice will changed too.

	ex:
	var myArray = [10]number{1,2,3,4,5,6,7,8,9,10}
							 0,1,2,3,4,5,6,7,8,9 -> index of myArray
	var mySlice = myArray[5:8]	// 5,6,7
	mySlice[0]	= 100 			// it's mean, you change the value of:
								// - mySlice at index 0 from 5 to 100
								// - myArray at index 5 from 5 to 100
								//	 (index 0 of mySlice is sliced array from myArray at index 5)

	fmt.Println(mySlice[0])		// 100
	fmt.Println(myArray[5])		// 100
	*/

	fmt.Println("- Slice & Update value - ")
	fmt.Println("")
	var slice6 = months[4:7]
	fmt.Println("var slice6 = months[4:7]")
	fmt.Println("months[4] = ", months[4])
	fmt.Println("slice6[0] = ", slice6[0])
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")
	fmt.Println("you change the value, then months[4] & slice6[0] will be affected")
	fmt.Println("because months[4] & slice6[0] is connected by pointer")
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")
	slice6[0] = "ALLOFMONTHS"
	fmt.Println("slice6[0] = \"ALLOFMONTHS\" ")
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")
	fmt.Println("months[4] = ", months[4])
	fmt.Println("slice6[0] = ", slice6[0])
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")
	fmt.Println("and let see the final value of months[] & slice6[]")
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")
	fmt.Println("months", months)
	fmt.Println("slice6                             ", slice6)

	fmt.Println("")

	/**
	fmt.Println("Append")
	// bikin pusing....

	var monthsA = [12]string{
		"januari",
		"februari",
		"maret",
		"april",
		"mei",
		"juni",
		"juli",
		"agustus",
		"september",
		"oktober",
		"november",
		"desember",
	}

	var monthsSliceA1 = monthsA[0:]
	monthsSliceA1[2] = "MARET"
	monthsSliceA1[3] = "APRIL"

	var monthsSliceA2 = append(monthsSliceA1, "juni")
	monthsSliceA2[0] = "JANUARI"
	fmt.Println(monthsA)
	fmt.Println(monthsSliceA1)
	fmt.Println(monthsSliceA2)

	fmt.Println("")

	var monthsB = [12]string{
		"januari",
		"februari",
		"maret",
		"april",
		"mei",
		"juni",
		"juli",
		"agustus",
		"september",
		"oktober",
		"november",
		"desember",
	}

	var monthsSliceB1 = monthsB[0:]
	monthsSliceB1[2] = "MARET"
	monthsSliceB1[3] = "APRIL"

	var monthsSliceB2 = append(monthsSliceB1, "juni")
	monthsSliceB2[0] = "JANUARI"
	fmt.Println(monthsB)
	fmt.Println(monthsSliceB1)
	fmt.Println(monthsSliceB2)
	*/

	/**
	fmt.Println("monthsSlice values  ", monthsSlice, "             // before append")
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")
	var monthsSlice2 = append(monthsSlice, "otherMonths")
	monthsSlice2[0] = "test"
	fmt.Println("monthsSlice values  ", monthsSlice, "             // after append")
	fmt.Println("monthsSlice2 values ", monthsSlice2, " // append new element into monthsSlice2 but ")
	fmt.Println("                                                                             // monthsSlice is not affected")
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")
	fmt.Println("see? monthsSlice not affected, because append is slice the monthsSlice value then move it into new memory a.k.a new variable")
	fmt.Println("let's update the value of monthsSlice2")
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")
	fmt.Println("months values       ", monthsSlice, "             // before update")
	fmt.Println("monthsSlice values  ", monthsSlice, "             // before update")
	fmt.Println("monthsSlice2 values ", monthsSlice2, " // before update")
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")
	fmt.Println("monthsSlice2[0] = \"FIRSTMONTH\"")
	monthsSlice2[0] = "FIRSTMONTH"
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")
	fmt.Println("months values       ", monthsSlice, "             // after update")
	fmt.Println("monthsSlice values  ", monthsSlice, "             // after update")
	fmt.Println("monthsSlice2 values ", monthsSlice2, " // after update")
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")
	fmt.Println("funfact: after append, the slice still connected to the source of sliced array, and the value of array is updated too")
	fmt.Println("----------------------------------------------------------------------------------------------------------------------------")

	days := [...]string{"senin", "selasa", "rabu", "kamis"}
	daySlice1 := days[1:]
	daySlice1[0] = "SELASA"
	daySlice1[1] = "RABU"

	daySlice2 := append(daySlice1, "jumat")
	daySlice2[0] = "UPS"
	fmt.Println(days)
	fmt.Println(daySlice1)
	fmt.Println(daySlice2)
	*/
}
