package kotlin02_oop.lesson19_equals_function

import kotlin02_oop.lesson17_type_check_casts.divider

/**
 * Equals Function
 *
 * - Di Kotlin, semua objek bisa dibandingkan menggunakan operasi
 *   == atau !=.
 * - Saat kita membandingkan objek menggunakan operasi == atau !=,
 *   sebenarnya Kotlin akan menggunakan function equals milik class
 *   Any.
 * - Untuk mengubah cara membandingkannya, kita bisa meng-override
 *   function equals milik class Any.
 */
class Company(var name: String) {}

/* Menggunakan equals() default */
fun defaultEquals() {
    val company1: Company = Company("HP")
    val company2: Company = Company("HP")
    println(company1 == company2) // false
    println("\n")
}

class NashTa(var name: String) {

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is NashTa -> this.name == other.name
            else -> false
        }
    }

}

/* Menggunakan equals() override */
fun overrideEquals() {
    val nashta1: NashTa = NashTa("HP")
    val nashta2: NashTa = NashTa("HP")
    println(nashta1 == nashta2) // false
    println("\n")
}

fun main() {
    divider("DEFAULT EQUALS", 3)
    defaultEquals()

    divider("OVERRIDE EQUALS", 3)
    overrideEquals()
}