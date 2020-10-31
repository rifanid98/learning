package main

import "fmt"

func main() {
	/**
	#Boolean Operation#

	|	Operator	|	Description	|
	---------------------------------
	|	&&			|	And			|
	|	||			|	Or			|
	|	!			|	Opposite	|

	ex:
	&& (And)
	true 	&& 	true 	=> true
	true 	&& 	false 	=> true
	false 	&& 	true 	=> false
	false 	&& 	false 	=> false

	|| (Or)
	true 	|| 	true 	=> true
	true 	|| 	false 	=> true
	false 	|| 	true 	=> true
	false 	|| 	false 	=> false

	! (Or)
	!true 	=> false
	!false	=> true
	*/

	var (
		nilaiAkhir = 90
		absensi    = 80
	)

	var lulusNilaiAkhir bool = nilaiAkhir > 80 // true
	var lulusAbsesnsi bool = absensi > 80      // false

	var lulus bool = lulusNilaiAkhir && lulusAbsesnsi // true && false = false
	fmt.Println("Lulus?", lulus)
}
