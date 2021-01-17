package kotlin02_oop.lesson49_polymorphism

/**
 * Polymorphism
 *
 * - Polymorphism berasal dari bahasa Yunani yang berarti banyak bentuk.
 * - Dalam OOP, Polymorphism adalah kemampuan sebuah object berubah bentuk
 *   menjadi bentuk lain.
 * - Polymorphism erat hubungannya dengan Inheritance.
 */
open class Employee(val name: String) {
    open fun sayHello(name: String) {
        println("Hello $name, my name is Employee ${this.name}")
    }
}

class Manager(name: String): Employee(name) {
    override fun sayHello(name: String) {
        println("Hello $name, my name is Manager ${this.name}")
    }
}

class VicePresident(name: String): Employee(name) {
    override fun sayHello(name: String) {
        println("Hello $name, my name is Vice President ${this.name}")
    }
}

fun main() {
    var employee: Employee = Employee("Adnin")
    employee.sayHello("Budi")

    employee = Manager("Adnin")
    employee.sayHello("Budi")

    employee = VicePresident("Adnin")
    employee.sayHello("Budi")
}