package kotlin02_oop.lesson25_interface

import kotlin02_oop.lesson17_type_check_casts.divider

// #################################################################
//                              INTERFACE
// #################################################################
/**
 * Interface
 *
 * - Di kotlin, deklarasi type tidak hanya dalam bentuk class, ada
 *   juga interface.
 * - Interface adalah blueprint, prototype atau cetakan di Kotlin.
 * - Berbeda dengan Class, Interface tidak bisa langsung dibuat
 *   sebagai Object.
 * - Interface hanya bisa diturunkan, dan biasanya Interface
 *   digunakan sebagai kontrak untuk class - class turunannya.
 * - Secara standar, semua properties dan function di Interface
 *   adalah abstract.
 */
interface Interaction {
    val name: String
    fun sayHello(name: String): Unit
}

/* Implements Interaction interface */
class Human(override val name: String): Interaction {
    override fun sayHello(name: String) {
        println("Hello $name!, my name is ${this.name}")
    }
}

fun runInterface() {
    val human: Human = Human("Adnin")
    human.sayHello("Budi")
}

// #################################################################
//                     CONCRETE FUNCTION DI INTERFACE
// #################################################################
/**
 * Concrete Function di Interface
 *
 * - Function di Interface memiliki pengecualian, tidak harus abstract.
 * - Kita bisa membuat concrete function di Interface, artinya function
 *   tersebut tidak wajib untuk dibuat ulang di child Class nya.
 */
interface Interaction2 {
    val name: String
    /* Concrete Function */
    fun sayHello(name: String) {
        println("Hello $name, my name is ${this.name}!")
    }
}

/* Implements Interaction2 interface */
class Human2(override val name: String): Interaction2 {}

fun runConcreteFunctionInterface() {
    val human: Human2 = Human2("Adnin")
    human.sayHello("Budi")
}

// #################################################################
//                   MULTIPLE INHERITANCE INTERFACE
// #################################################################
/**
 * Multiple Inheritance dengan Interface
 *
 * - Inheritance di Class hanya boleh memiliki satu class Parent.
 * - Di Interface, sebuah class Child bisa memiliki banyak interface
 *   Parent.
 */
interface Go {
    fun go(): Unit {
        println("Go!")
    }
}

open class Contoh
open class Contoh2

class Human3(override val name: String): Contoh(), Interaction2, Go
//class Human3(override val name: String): Contoh(), Contoh2(), Interaction2, Go
// ERROR. Only one class may appear in a supertype list.

fun runMultipleInheritance() {
    val human: Human3 = Human3("Adnin")
    human.sayHello("Budi")
    human.go()
}

// #################################################################
//                   INHERITANCE ANTAR INTERFACE
// #################################################################
/**
 * Inheritance antar Interface
 *
 * - Tidak hanya Class yang punya kemampuan Inheritance.
 * - Interface juga bisa melakukan Inheritance dengan Interface lain.
 * - Namun Interface tidak bisa melakukan Inheritance dengan Class.
 */
interface UnitedInterface: Go, Interaction2 {
    override val name: String
}

class Human4(override val name: String): UnitedInterface

fun runInheritanceAntarInterface() {
    val human: Human4 = Human4("Adnin")
    human.sayHello("Budi")
    human.go()
}

// #################################################################
//                          KONFLIK DI INTERFACE
// #################################################################
/**
 * Konflik di Interface
 *
 * - Terkadang kita membuat lebihd dari satu interface yang memiliki
 *   method yang sama.
 * - Ketika mengimplemen method yang ada di interface yang methodnya
 *   sama, kita haanya bisa mengoverride dengan menggunakan satu method
 *   saja.
 * - Untuk menentukan interface mana yang ingin diakses, menggunakan
 *   super<namaInterface>.namaMethod()
 */
interface MoveA {
    fun move(): Unit = println("Move A")
}

interface MoveB {
    fun move(): Unit = println("Move B")
}

/* Implements MoveA & MoveB Interface */
class Human5: MoveA, MoveB {
    override fun move() {
        super<MoveA>.move()
        super<MoveB>.move()
    }
}

fun runKonflikInterface() {
    val human: Human5 = Human5()
    human.move()
}

fun main() {
    divider("Interface", 5)
    runInterface()

    divider("Concrete Function Interface", 3)
    runConcreteFunctionInterface()

    divider("Multiple Inheritance", 4)
    runMultipleInheritance()

    divider("Inheritance antar Inheritance", 3)
    runInheritanceAntarInterface()

    divider("Konflik Interface", 4)
    runKonflikInterface()
}