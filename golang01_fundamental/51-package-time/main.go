package main

import (
	"fmt"
	"time"
)

/**
#Package time#

-------------------------------------------------------------
|	method			|	description							|
-------------------------------------------------------------
|	time.Now()					|	get today time			|
|	time.Date(...)				|	make a time				|
|	time.Parse(layout, string)	|	parse string to time	|
-------------------------------------------------------------
*/
func main() {
	timeNow()
	timeDate()
	timeParse()
}

func timeNow() {
	now := time.Now()

	fmt.Println(now)
	fmt.Println(now.Year())
	fmt.Println(now.Month())
	fmt.Println(now.Day())
	fmt.Println(now.Hour())
	fmt.Println(now.Minute())
	fmt.Println(now.Second())
	fmt.Println(now.Nanosecond())
}

func timeDate() {
	local := time.Date(2020, 10, 14, 15, 56, 00, 00, time.Local)
	fmt.Println(local)
}

func timeParse() {
	layout := "2006-01-02"
	dateString := "1990-03-20"
	date, _ := time.Parse(layout, dateString)
	// if err != nil {
	fmt.Println(date)
	// } else {
	// 	fmt.Println("Error:", err)
	// }
}
