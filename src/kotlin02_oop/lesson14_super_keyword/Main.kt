package kotlin02_oop.lesson14_super_keyword

/**
 * Super Keyword
 *
 * - Kadang kita ingin mengakses function atau properties milik class Parent yang sudah dibuat
 *   ulang oleh class Child.
 * - Untuk mengakses function  atau properties milik class Parent, kita bisa menggunakan kata
 *   kunci super.
 */
/* Parent Class */
open class Shape {
    open val corner: Int = -1

    open fun printName() {
        println("This is a shape")
    }
}

/* Child Class */
class Rectangle(): Shape() {
    override val corner: Int = 4
    val parentCorner: Int = super.corner

    override fun printName() {
        println("This is a rectangle")
    }

    fun printParentName() {
        super.printName()
    }

    fun getCorner(): Unit {
        println("Child Corner \t: ${this.corner}")
    }

    fun getParentCorner(): Unit {
        println("Parent Corner \t: ${super.corner}")
    }
}

fun main() {
    val rectangle: Rectangle = Rectangle()
    rectangle.getCorner()
    println("Parent Corner \t: ${rectangle.parentCorner}")
    rectangle.getParentCorner()
    rectangle.printName()
    rectangle.printParentName()
}
