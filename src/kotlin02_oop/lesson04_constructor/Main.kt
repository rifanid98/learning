package kotlin02_oop.lesson04_constructor

/**
 * Constructor
 *
 * - Saat kita membuat Object, maka kita seperti memanggil sebuah function.
 * - Di dalam class Kotlin, kita bisa membuat Constructors, Constructors mirip
 *   seperti function yang akan dipanggil saat pertama kali Object dibuat.
 * - Mirip seperti di Function, kita membuat constructor layaknya membuat function
 *   biasa.
 * - Karena constructor di Kotlin seperti function, maka kita juga bisa memberikan
 *   parameter di constructor layaknya parameter pada sebuah function.
 */
/* Cara 1 */
class Person (
    firstName: String,
    middleName: String?,
    lastName: String
) {
    var firstName: String = firstName
    var middleName: String? = middleName
    var lastName: String = lastName
}

/* Cara 2 */
class Hooman (
    // langsung mengisi default value dari
    // masing-masing parameter constructornya
    firstName: String = "",
    middleName: String? = null,
    lastName: String = ""
) {}

fun main() {
    val person: Person = Person(
        "Adnin",
        "Rifandi Sutanto",
        "Putra"
    )
    // get properties
    println(person.firstName)
    println(person.middleName)
    println(person.lastName)
}