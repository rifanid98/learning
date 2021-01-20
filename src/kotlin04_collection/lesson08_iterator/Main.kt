package kotlin04_collection.lesson08_iterator

import kotlin04_collection.lesson01_pengenalan.divider

/**
 * Iterator
 *
 * - Sebelumnya kita sudah bahas tentang Iterator di Iterable dan
 *   MutableIterator di MutableIterable.
 * - Iterator juga memiliki child interface, yaitu ListIterator dan
 *   MutableListIterator.
 * - ListIterator digunakan oleh List, dan MutableListIterator digunakan
 *   oleh MutableList.
 * - Set tetap menggunakan Iterator.
 * - Sedangkan Map tidak mendukung Iterator.
 */
fun <T> displayListIterator(listIterator: ListIterator<T>): Unit {
    println("----- increment")
    while (listIterator.hasNext()) println(listIterator.next())
    println("----- decrement")
    while (listIterator.hasPrevious()) println(listIterator.previous())
}

fun runListIterator() {
    displayListIterator(listOf("Adnin", "Rifandi", "Sutanto", "Putra").listIterator())
}

/**
 * Mutable List Iterator
 */
fun <T> displayMutableListIterator(mutableListIterator: MutableListIterator<T>, title: Boolean = false): Unit {
    if (title) println("--- increment")
    while (mutableListIterator.hasNext()) println(mutableListIterator.next())
    if (title) println("--- decrement")
    while (mutableListIterator.hasPrevious()) println(mutableListIterator.previous())
}

fun removeOddNumber(mutableListIterator: MutableListIterator<Int>) {
    while (mutableListIterator.hasNext()) {
        val item = mutableListIterator.next()
        if (item % 2 == 1) mutableListIterator.remove()
    }
}

fun runMutableListIterator() {
    println("----- #1")
    displayMutableListIterator(mutableListOf<Int>(1, 2, 3, 4, 5).listIterator(), true)

    var mutableListIterator = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).listIterator()
    println("----- #2")
    println("removeOddNumber()")
    removeOddNumber(mutableListIterator)
    println("----- #3")
    displayMutableListIterator(mutableListIterator)


}

fun main() {
    divider("List Iterator", 5)
    runListIterator()

    divider("Mutable List Iterator", 4)
    runMutableListIterator()
}