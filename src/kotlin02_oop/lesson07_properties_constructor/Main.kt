package kotlin02_oop.lesson07_properties_constructor

/**
 * Properties di Constructor
 *
 * - Kotlin mendukung deklarasi properties langsung di primary constructor.
 * - Ini sangat berguna untuk mempersingkat saat kita ingin membuat properties,
 *   dan mengisi datanya lewat constructor.
 */
class Person(
    var firstName: String = "",
    var middleName: String? = null,
    var lastName: String = ""
) {}

fun main() {
    val eko: Person = Person("Eko", "Tengah", "Akhir")
    val joko: Person = Person(firstName = "Joko", lastName = "Akhir")
}