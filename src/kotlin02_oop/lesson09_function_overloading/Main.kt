package kotlin02_oop.lesson09_function_overloading

/**
 * Function Overloading
 *
 * - Function Overloading adalah kemampuan membuat function dengan nama
 *   yang sama di dalam class.
 * - Untuk membuat function dengan nama yang sama, kita wajib menggunakan
 *   parameter yang berbeda, bisa tipe parameter yang berbeda, atau jumlah
 *   parameter yang berbeda.
 */
class Person(val name: String) {

    fun sayHello(yourName: String): Unit {
        println("Hello $yourName, my name is $name")
    }

    /**
     * Function Overloading
     */
    fun sayHello(firstName: String, lastName: String): Unit {
        println("Hello $firstName $lastName, my name is $name")
    }
}

fun main() {
    val person: Person = Person("Rifandi")
    person.sayHello("Adnin")
    person.sayHello("Adnin", "Sutanto")
}