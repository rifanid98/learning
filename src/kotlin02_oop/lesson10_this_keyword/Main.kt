package kotlin02_oop.lesson10_this_keyword

/**
 * This Keyword
 *
 * - this adalah keyword yang bisa digunakan untuk mereferensikan object saat ini.
 * - this hanya bisa digunakan di dalam class itu sendiri.
 * - Biasanya, this digunakan untuk mengakses properties yang tertutup oleh parameter
 *   dengan nama yang sama.
 */
class Person(val name: String) {

    fun sayHello(name: String): Unit {
        println("Hello $name, my name is $name") // $name refer ke function parameter
        println("Hello $name, my name is ${this.name}") // ${this.name} refer ke object property
    }
}

fun main() {
    var person: Person = Person("Rifandi")
    person.sayHello("Adnin")
}