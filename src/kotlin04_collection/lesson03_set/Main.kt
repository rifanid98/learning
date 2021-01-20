package kotlin04_collection.lesson03_set

import kotlin04_collection.lesson01_pengenalan.divider

//####################################################################
//                              SET
//####################################################################

class Person(val name: String) {

    override fun hashCode(): Int {
        return name.hashCode()
    }

    /**
     * Penggunaan when 1
     * digunakan di dalam blok kode
     */
    override fun equals(other: Any?): Boolean {
        return when(other) {
            is Person -> name == other.name
            else -> false
        }
    }

    /**
     * Penggunaan when 2
     * digunakan langsung setelah return type memanfaatkan fitur
     * inline function declaration
     */
    //override fun equals(other: Any?): Boolean = when (other) {
    //    is Person -> name == other.name
    //    else -> false
    //}

}
/**
 * Set
 *
 * - Set, adalah collection yang datanya harus unik dan tidak pasti
 *   berurut.
 * - Saat kita memasukkan data duplicate ke Set, maka data hanya akan
 *   disimpan satu, data duplicatenya tidak akan ditambahkan ke dalam
 *   Set.
 * - Set sangat cocok untuk menyimpan data yang emang unik, tidak boleh
 *   sama.
 * - Set menggunakan function hashCode() dan equals() untuk
 *   membandingkan apakah sebuah object sama atau tidak, jika hashCode()
 *   dan equals() nya sama, maka diangkap data tersebut duplicate, dan
 *   tidak akan diterima oleh Set.
 */
fun runSet() {
    val set: Set<Person> = setOf(
        Person("Adnin"),
        Person("Rifandi"),
        Person("Sutanto"),
        Person("Putra"),
        Person("Sutanto") // duplicate. maka akan diignore
    )

    println(set.size)
    println(set.contains(Person("Sutanto")))
}

/**
 * Mutable Set
 */
fun runMutableSet() {
    val mutableSet: MutableSet<Person> = mutableSetOf(
        Person("Adnin"),
        Person("Rifandi"),
        Person("Sutanto")
    )

    println(mutableSet.size)
    mutableSet.add(Person("Putra"))
    println(mutableSet.size)
    mutableSet.add(Person("Putra"))
    println(mutableSet.size)
    println(mutableSet.contains(Person("Sutanto")))
}

fun main() {
    divider("Set", 6)
    runSet()

    divider("Mutable Set", 5)
    runMutableSet()
}