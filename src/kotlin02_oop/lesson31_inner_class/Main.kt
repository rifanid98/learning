package kotlin02_oop.lesson31_inner_class

/**
 * Inner Class
 *
 * - Di Kotlin, kita bisa membuat class (Inner) di dalam class (Outer).
 * - Namun walaupun class Inner tersebut berada di dalam class Outer,
 *   namun class Inner tidak bisa mengakses data yang ada di dalam class Outer.
 * - Agar class Inner bisa mengakses data yang ada di dalam class Outer,
 *   kita bisa menggunakan kata kunci inner.
 */
class Boss(val name: String) {

    class Employee1(val name: String) {

        fun hi(): Unit {
            println("Hi! My name is ${this.name}")
        }

    }

    inner class Employee2(val name: String) {

        fun hi(): Unit {
            println("Hi! My name is ${this.name}, my boss is ${this@Boss.name}")
        }

    }
}

fun main() {
    /* Without inner keyword */
    val employee1: Boss.Employee1 = Boss.Employee1("Adnin")
    employee1.hi()

    /* With inner keyword */
    val employee2: Boss = Boss("Adnin")
    val employee3: Boss.Employee2 = employee2.Employee2("Budi")
    employee3.hi()
}