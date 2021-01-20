package kotlin04_collection.lesson07_iterable

import kotlin04_collection.lesson01_pengenalan.divider

/**
 * Iterable
 *
 * - Iterable adalah superclass dari Collection interface.
 * - Iterable adalah general operation untuk melakukan iterasi seluruh
 *   data di collection, atau menghapus data di collection.
 */
fun <T> displayIterable(iterable: Iterable<T>): Unit {
    val iterator = iterable.iterator()
    while (iterator.hasNext()) println(iterator.next())
}

fun runIterable() {
    displayIterable(listOf("Adnin", "Rifandi"))
    displayIterable(setOf("Adnin", "Rifandi"))
}

/**
 * Mutable Iterator
 */
fun <T> displayMutableIterable(iterable: MutableIterable<T>): Unit {
    val iterator = iterable.iterator()
    while (iterator.hasNext()) println(iterator.next())
}

fun runMutableIterable() {
    displayMutableIterable(mutableListOf("Adnin", "Rifandi"))
    displayMutableIterable(mutableSetOf("Adnin", "Rifandi"))
}

fun main() {
    divider("Iterable", 6)
    runIterable()

    divider("Mutable Iterable", 5)
    runMutableIterable()
}