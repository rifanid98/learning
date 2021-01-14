package kotlin02_oop.lesson42_operator_overloading

/**
 * Operator Overloading
 *
 * - Kotlin mendukung operator overloading, artinya kita bisa membuat
 *   function dari operator-operator seperti operator matematika, dan
 *   lain-lain.
 * - Kemampuan ini membuat kita bisa melakukan operasi apapun di object
 *   seperti layaknya tipe data Integer.
 * - Ada banyak sekali operator yang bisa di override di Kotlin.
 */
data class Fruit(val qty: Int) {
    /**
     * Membuat Operator Overloading
     *
     * Untuk membuat operator overloading, kita bisa menggunakan kata kunci
     * operator sebelum deklarasi function nya.
     */
    operator fun plus(fruit: Fruit): Fruit {
        return Fruit(qty + fruit.qty)
    }

    operator fun minus(fruit: Fruit): Int {
        return qty - fruit.qty
    }
}

fun main() {
    val fruit1: Fruit = Fruit(100)
    val fruit2: Fruit = Fruit(50)

    val totalPlus: Fruit = fruit1 + fruit2
    val totalMinus: Int = fruit1 - fruit2

    println(totalPlus)
    println(totalMinus)
}