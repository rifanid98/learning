package kotlin04_collection.lesson19_plus_minus_operator

/**
 * Plus & Minus Operators
 *
 * - Di kotlin, ada operator extension function plus dan minus untuk collection.
 * - Parameter pertama adalah collection, dan parameter selanjutnya bisa
 *   collection atau element, dan akan menghasilkan collection baru.
 */
/*
    Plus & Minus Operators
    -------------------------------------------------------------------------------
    |   Plus & Minus Operators  |                    Keterangan                   |
    -------------------------------------------------------------------------------
    | plus(element)             | Membuat collection baru dengan menambahkan      |
    |                           | element.                                        |
    |-----------------------------------------------------------------------------|
    | plus(collection)          | Membuat collection baru dengan menambahkan      |
    |                           | collection.                                     |
    |-----------------------------------------------------------------------------|
    | minus(element)            | Membuat collection baru dengan menghapus        |
    |                           | element.                                        |
    |-----------------------------------------------------------------------------|
    | minus(collection)         | Membuat collection baru dengan menghapus        |
    |                           | collection.                                     |
    -------------------------------------------------------------------------------
*/
fun main() {
    val list1: List<String> = listOf("Adnin", "Rifandi", "Sutanto")
    val list2: List<String> = list1 + "Putra"
    val list3: List<String> = list1 + listOf<String>("Coding", "Kotlin")
    val list4: List<String> = list1 - "Sutanto"
    val list5: List<String> = list1 - listOf<String>("Rifandi", "Sutanto")

    println("list1\t: $list1")
    println("list2\t: $list2")
    println("list3\t: $list3")
    println("list4\t: $list4")
    println("list5\t: $list5")

    val map1: Map<String, Any> = mapOf(
        "name" to "Adnin",
        "age" to 22
    )
    val map2: Map<String, Any> = map1 + mapOf<String, Boolean>(Pair("married", false))
    val map3: Map<String, Any> = map1 - "married"

    println("map1\t: $map1")
    println("map2\t: $map2")
    println("map3\t: $map3")
}