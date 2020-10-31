package main

import (
	"fmt"
	"math"
)

/**
#Package Math#

-------------------------------------------------------------------------
|	method						|	functionality						|
-------------------------------------------------------------------------
|	math.Round(float64)			|	Rounding up or down					|
|	math.Floor(float64)			|	Rounding down						|
|	math.Ceil(float64)			|	Rounding up							|
|	math.Max(float64, float64)	|	Find out the highest value / number	|
|	math.Min(float64, float64)	|	Find out the lowest value / number	|
-------------------------------------------------------------------------
*/
func main() {
	fmt.Println(math.Round(1.7))  // 2
	fmt.Println(math.Round(1.3))  // 1
	fmt.Println(math.Floor(1.7))  // 1
	fmt.Println(math.Ceil(1.3))   // 2
	fmt.Println(math.Max(10, 20)) // 20
	fmt.Println(math.Min(10, 20)) // 10
}
