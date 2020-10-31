package main

import "fmt"

/**
#Pointer#
-	Secara default setiap bahasa pemograman akan mengirimkan value
	dari suatu variable, bukan variable itu sendiri
	contoh:
		name := "Adnin"
		newName := name // yang dikirim ke newName hanya value "Adnin"
						// bukan "name" itu sendiri
-	Apabila kita mengirimkan valuenya saja, maka ketika mengubah
	variable newName, maka variable name tidak akan terpengaruh.
-	Dengan pointer, yang dikirim adalah value beserta variable name nya,
	bukan valuenya saja. Efeknya, ketika kita mengubah value variableName,
	secara tidak otomatis, kita mengubah value dari variable name. sedangkan
	variable newName hanyalah perantanya saja

// operator 1: &
Operator & membuat variable yang menggunakannya mengikuti alamat memory
dari variable yang direferensikan.

ex:
func functionName() {
	variableName := "Adnin"
	newVariableName := &variableName

	newVariableName = "Rifandi"
	fmt.Println(variableName)		// Rifandi
	fmt.Println(newVariableName)	// Rifandi
}

// operator 2: *
Operator * membuat variable yang telah menggunakan operator &, memaksa
variable yang direferensikan mengikuti kehendak variable yang menggunakan
operator & untuk pindah memory ke alamat memory yang baru sesuai dengan
alamat memory yang baru, yang direferensikan oleh si variable yang menggunakan
operator & tadi

ex:
func functionName() {
	variableName := "Adnin"
	newVariableName := &variableName

	newVariableName = "Rifandi"
	fmt.Println(variableName)		// Rifandi
	fmt.Println(newVariableName)	// Rifandi

	variableNew := "Sutanto"
	newVariableName = &variableNew

	fmt.Println(variableName)		// Rifandi
	fmt.Println(newVariableName)	// Sutanto

	*newVariableName = &variableNew
	fmt.Println(variableName)		// Sutanto
	fmt.Println(newVariableName)	// Sutanto
}
*/

func main() {
	/** operator & */
	// pointer1()

	/** operator * */
	// pointer2()

	/** pointer in function */
	// manusia := Manusia{"Adnin"}
	// pointer3(&manusia) // &{Rifandi}

	/** pointe in struct method */
	// manusia2 := Manusia{"Rifandi"}
	// manusia2.pointer4() // &{Sutanto}
}

/** operator & */
func pointer1() {
	person := [...]string{"Adnin", "Rifandi", "Sutanto", "Putra"}

	personValue := person
	personValue[0] = "Impostor"

	fmt.Println("Pass by Value")
	fmt.Println("--------------")
	fmt.Println(person)
	fmt.Println(personValue)
	fmt.Println("--------------")

	personReference := &person
	personReference[0] = "Impostor"

	fmt.Println("Pass by Reference")
	fmt.Println("--------------")
	fmt.Println(person)
	fmt.Println(personReference)
	fmt.Println("--------------")
}

/** operator * */
func pointer2() {
	person := [...]string{"Adnin", "Rifandi", "Sutanto", "Putra"}
	personValue := person
	personValue[0] = "Impostor"

	fmt.Println("Pass by Value")
	fmt.Println("--------------")
	fmt.Println(person)      // Adnin Rifandi Sutanto Putra
	fmt.Println(personValue) // Impostor Rifandi Sutanto Putra
	fmt.Println("--------------")

	personReference := &person
	personReference[0] = "Impostor"

	fmt.Println("Pass by Reference")
	fmt.Println("--------------")
	fmt.Println(person)          // Impostor Rifandi Sutanto Putra
	fmt.Println(personReference) // Impostor Rifandi Sutanto Putra
	fmt.Println("--------------")

	person2 := [...]string{"Adnin", "Rifandi", "Sutanto", "Putra"}
	*personReference = person2
	personReference[1] = "Impostor"

	fmt.Println("Force person to Follow personReference")
	fmt.Println("--------------")
	fmt.Println(person)          // Adnin Impostor Sutanto Putra
	fmt.Println(personReference) // Adnin Impostor Sutanto Putra
	fmt.Println("--------------")
}

// Manusia struct
type Manusia struct {
	Name string
}

/** pointer di function */
func pointer3(person *Manusia) {
	person.Name = "Rifandi"
	fmt.Println(person)
}

/** method of Manusia */
func (manusia *Manusia) pointer4() {
	manusia.Name = "Sutanto"
	fmt.Println(manusia)
}
