package kotlin04_collection.lesson06_collection

import kotlin04_collection.lesson01_pengenalan.divider

/**
 * Collection
 *
 * - Semua data collection adalah turunan dari interface Collection.
 * - Collection digunakan sebagai general operation terhadap struktur
 *   data collection, seperti membaca dan menulis data di collection.
 */
fun <T> displayCollection(collection: Collection<T>): Unit {
    for (item in collection) println(item)
}

fun runCollection() {
    displayCollection(listOf("Adnin", "Rifandi", "Sutanto", "Putra"))
    displayCollection(setOf("Adnin", "Rifandi", "Sutanto", "Putra"))
    displayCollection(mapOf(Pair("name", "Adnin")).entries)
    //displayCollection(mapOf("name" to "address")) // ERROR. map bukan collection
}

/**
 * Mutable Collection
 */
fun <T> displayMutableCollection(collection: Collection<T>): Unit {
    for (item in collection) println(item)
}

fun runMutableCollection() {
    displayMutableCollection(mutableListOf("Adnin", "Rifandi", "Sutanto", "Putra"))
    displayMutableCollection(mutableSetOf("Adnin", "Rifandi", "Sutanto", "Putra"))
    displayMutableCollection(mutableMapOf(Pair("name", "Adnin")).entries)
    //displayMutableCollection(mutableMapOf("name" to "adnin")) // ERROR. map bukan collection
}

fun main() {
    divider("Collection", 6)
    runCollection()

    divider("Mutable Collection", 5)
    runMutableCollection()
}