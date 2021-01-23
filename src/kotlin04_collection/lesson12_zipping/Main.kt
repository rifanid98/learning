package kotlin04_collection.lesson12_zipping

import kotlin04_collection.lesson01_pengenalan.divider

/**
 * Transformations: Zipping
 *
 * - Zipping adalah transformasi yang digunakan untuk menggabungkan dua buah
 *   collection.
 */
/*
    Zipping Operations
    ---------------------------------------------------------------------------
    |     Zipping Operations    |                 Keterangan                  |
    ---------------------------------------------------------------------------
    | zip(collection)           | Menggabungkan dua collection, sehingga      |
    |                           | menghasilkan pair<T1, T2>.                  |
    |-------------------------------------------------------------------------|
    | zip(collection,           | Menggabungkan dua collection dengan lambda  |
    | transform: (T1, T2) -> R) | transform sehingga menghasilkan collection  |
    |                           | baru dari result lambda transformnya.       |
    ---------------------------------------------------------------------------
 */
fun runZipping() {
    println("----- example 1")
    val ex1list1: List<String> = listOf("Adnin", "Rifandi", "Sutanto")
    val ex1list2: List<String> = listOf("Sutanto", "Putra")

    val ex1list3: List<Pair<String, String>> = ex1list1.zip(ex1list2)
    val ex1list4: List<String> = ex1list1.zip(ex1list2) {item1, item2 ->
        item1 + item2
    }

    println(ex1list3)
    println(ex1list4)

    println("----- example 2")
    val ex2list1: List<String> = listOf("Name", "Age", "Married")
    val ex2list2: List<Any> = listOf("Adnin", 22, false)

    val ex2list3: List<Pair<String, Any>> = ex2list1.zip(ex2list2)
    val ex2list4: List<String> = ex2list1.zip(ex2list2) {item1, item2 ->
        "$item1:$item2"
    }

    println(ex2list3)
    println(ex2list4)
}

/*
    Unzipping Operations
    ---------------------------------------------------------------------------
    |     Unzipping Operations  |                 Keterangan                  |
    ---------------------------------------------------------------------------
    | unzip(collection)         | Mengubah collection Pair<T1, T2> menjadi    |
    |                           | dua collection, collection T1 dan collection|
    |                           | T2.                                         |
    ---------------------------------------------------------------------------
 */
fun runUnzipping() {
    val list: List<Pair<String, Any>> = listOf(
        Pair("Name", "Adnin"),
        "Age" to 22,
        "Married" to false
    )

    val pair: Pair<List<String>, List<Any>> = list.unzip()
    println(pair)
    val (list1, list2) = pair
    println(list1)
    println(list2)
}

fun main() {
    divider("Zipping Operations", 5)
    runZipping()

    divider("Unzipping Operations", 5)
    runUnzipping()
}