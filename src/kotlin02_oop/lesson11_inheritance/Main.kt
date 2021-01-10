package kotlin02_oop.lesson11_inheritance

/**
 * Inheritance
 *
 * - Inheritance atau pewarisan adalah kemampuan untuk menurunkan sebuah class ke class lain.
 * - Dalam artian, kita bisa membuat class Parent dan class Child.
 * - Di Kotlin, tiap class Child, hanya bisa punya satu class Parent, namun satu class Parent
 *   bisa punya banyak class Child.
 * - Secara standar, di class yang dibuat di Kotlin adalah final (tidak bisa diwariskan), agar
 *   bisa diwariskan, kita harus menggunakan kata kunci open .
 */
/* Parent Class */
open class Person(val name: String) {

    fun sayHello(yourName: String): Unit {
        println("Hello $yourName, my name is ${this.name}")
    }
}

/* Child Class */
class Student(
    name: String,
    val School: String
): Person(name) {

    fun study() {
        println("${this.name} is studying")
    }
}

fun main() {
    val student: Student = Student("Adnin", "SMK N 1 Ciomas")
    student.sayHello("Eko")
    student.study()
}