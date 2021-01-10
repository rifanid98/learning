package kotlin02_oop.lesson13_properties_overriding

/**
 * Properties Overriding
 *
 * - Selain membuat ulang function di class Child, di Kotlin juga kita bisa membuat ulang properties.
 * - Secara standar, properties di class bersifat final, tidak bisa di buat ulang di class Child nya,
 *   agar bisa dibuat ulang, kita harus menggunakan kata kunci open.
 */
/* Parent Class */
open class Shape(open val corner: Int = -1)

/* Child Class */
class Rectangle(override val corner: Int = 4): Shape(corner) {

    fun getCorner(): Unit {
        println("Corner \t: ${this.corner}")
    }
}

fun main() {
    val rectangle: Rectangle = Rectangle()
    rectangle.getCorner()
}