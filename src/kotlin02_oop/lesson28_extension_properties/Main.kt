package kotlin02_oop.lesson28_extension_properties

/**
 * Extension Properties
 *
 * - Selain function, kita juga bisa membuat extension untuk properties
 *   di Kotlin.
 * - Untuk membuat extension properties, kita bisa membuat properties
 *   dengan Getter atau Setter.
 */
class Student(
    var name: String,
    private var age: Int
) {}

val Student.upperName: String
    get() = this.name.toUpperCase()

fun main() {
    val student: Student? = Student("Adnin", 22)
    println(student?.upperName)
}