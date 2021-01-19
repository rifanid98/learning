package kotlin03_generic.lesson07_generic_constraint

import kotlin02_oop.lesson49_polymorphism.Employee

/**
 * Generic Constraint
 *
 * - Kadang kita ingin membatasi data yang boleh digunakan di generic
 *   parameter type.
 * - Kita bisa menambahkan constraint di generic parameter type dengan
 *   menyebutkan tipe yang diperbolehkan.
 * - Secara otomatis, type data yang bisa digunakan adalah type yang
 *   sudah kita sebutkan, atau class-class turunannya.
 * - Secara default, constraint type untuk generic parameter type
 *   adalah Any, sehingga semua tipe data bisa digunakan.
 */
open class Employee1

class Manager1: Employee1()
class VicePresident1: Employee1()

class Company1<T: Employee1>(val employee: T)

fun runGenericConstraint() {
    val company1: Company1<Employee1> = Company1(Employee1())
    val company2: Company1<Employee1> = Company1(Manager1())
    val company3: Company1<Employee1> = Company1(VicePresident1())
    //val company4 = Company("Adnin") // ERROR. dibatasi hanya class Employee
}

/**
 * Where Keyword
 *
 * - Kadang kita ingin membatasi tipe data dengan beberapa jenis tipe
 *   data di generic parameter type.
 * - Secara default, hanya satu tipe data yang bisa digunakan untuk
 *   membatasi generic parameter type.
 * - Jika kita ingin menggunakan lebih dari satu tipe data, kita bisa
 *   menggunakan kata kunci where.
 */
interface CanSayHello {
    fun sayHello(name: String)
}

open class Employee2

class Manager2: Employee2()
class VicePresident2: Employee2(), CanSayHello {
    override fun sayHello(name: String) {
        println("Hello $name")
    }
}

class Company2<T>(val employee: T) where T: Employee2, T: CanSayHello

fun runWhereKeyword() {
    //val company1 = Company2("String")
    //val company2 = Company2(Manager2()) // ERROR. required CanSayHello
    val company3 = Company2(VicePresident2())
}
