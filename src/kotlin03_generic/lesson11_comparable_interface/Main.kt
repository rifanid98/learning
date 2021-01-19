package kotlin03_generic.lesson11_comparable_interface

/**
 * Comparable
 *
 * - Sebelumnya kita sudah tahu bahwa operator perbandingan == dan !=
 *   akan menggunakan metode equals sebagai implementasinya..
 * - Bagaimana dengan operator perbandingan lainnya? Seperti > >= < <=
 *   ?.
 * - Operator perbandingan tersebut bisa kita lakukan, jika object kita
 *   mewariskan interface generic Comparable.
 */
class Fruit(val name: String, val quantity: Int): Comparable<Fruit> {
    override fun compareTo(other: Fruit): Int {
        return quantity.compareTo(other.quantity)
    }
}

fun main() {
    val fruit1 = Fruit("Mangga", 10)
    val fruit2 = Fruit("Mangga", 100)

    println(fruit1 > fruit2)
    println(fruit1 < fruit2)
    println(fruit1 >= fruit2)
    println(fruit1 <= fruit2)
}
