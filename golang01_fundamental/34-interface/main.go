package main

import "fmt"

/**
#Interface#

#JavaScript#
-	type dan intterface adalah hal yang berbeda
-	type digunakan untuk membuat kontrak dengan suatu variabel
-	type hanya memiliki element berupa variabel
-	interface digunakan untuk membuat kontrak dengan class
-	interface memiliki element berupa variabel dan method

#GoLang#
-	type struct seperti layaknya interface di Javascript
	namun tidak di implementasikan
-	type struct hanya memiliki variabel namun bisa memiliki method
	dengan cara type tersebut didaftarkan kepada method yang
	ingin diadopsi menjadi method type tersebut
-	type interface hanya mempunyai method dan bisa diimplementasikan
	tetapi tidak bisa diimplementasikan secara langsung.
-	type interface butuh perantara berupa type struct agar bisa
	diimplementasikan. dengan begitu jika type struct yang dijadikan
	perantara memiliki variable maka variable tersebut menjadi
	milik type interface. begitupula dengan method.
- 	type struct akan mengambil alih method yang dimiliki oleh type
	struct apabila type struct memiliki method yang dibutuhkan oleh
	type interface
*/

// IPerson interface
type IPerson interface {
	GetName() string
}

// SPerson struct
type SPerson struct {
	Name string
}

// GetName method of SPerson
func (person SPerson) GetName() string {
	return person.Name
}

func main() {
	person()
}

func person() {
	var adnin SPerson
	adnin.Name = "Adnin"

	fmt.Println(adnin)
	student(adnin)
}

func student(iPerson IPerson) {
	fmt.Println("My name is", iPerson.GetName())
	fmt.Println("I'm studying...")
}
