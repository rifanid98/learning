package kotlin02_oop.lesson08_function

/**
 * Function
 *
 * - Selain Properties / Fields / Attributes, di dalam Class,
 *   kita juga bisa mendeklarasikan Function.
 * - Function yang kita deklarasikan di dalam Class, secara
 *   otomatis menjadi behaviour si object yang dibuat dari class tersebut.
 */
class Student(val name: String) {
    fun sayHello(yourName: String): Unit {
        println("Hello $yourName, my name is $name")
    }
}

fun main() {
    val student: Student = Student("Rifandi")
    student.sayHello("Adnin")
}