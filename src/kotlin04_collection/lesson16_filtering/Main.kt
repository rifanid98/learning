package kotlin04_collection.lesson16_filtering

/**
 * Filtering: Filtering by apredicate
 *
 * - Filtering adalah salah satu operasi collection yang sangat popular.
 * - Di kotlin, filtering bisa menggunakan predicate berupa lambda yang berisi
 *   kondisi filter nya.
 * - Jika return dari predicate tersebut true, maka data di terima, jika false
 *   maka data dibuang.
 */
/*
    Filtering by Predicate Operation
    -------------------------------------------------------------------------------
    |   Filtering Operation                |               Keterangan             |
    -------------------------------------------------------------------------------
    | filter((T) -> Boolean)               | Melakukan filtering terhadap         |
    |                                      | collection.                          |
    |-----------------------------------------------------------------------------|
    | filterIndexed((index, T) -> Boolean) | Melakukan filtering terhadap         |
    |                                      | collection dengan tambahan informasi |
    |                                      | index.                               |
    |-----------------------------------------------------------------------------|
    | filterNot((T) -> Boolean)            | Kebalikan dari filter((T) -> Boolean)|
    |-----------------------------------------------------------------------------|
    | filterIsInstance<T>()                | Mengambil hanya data instance dari T |
    |-----------------------------------------------------------------------------|
    | filterNotNull()                      | Mengambil hanya data yang tidak null |
    -------------------------------------------------------------------------------
*/
fun main() {
    val list1: List<String> = listOf("Adnin", "Rifandi", "Sutanto")
    val list2: List<String> = list1.filter { it.length > 5 }
    val list3: List<String> = list1.filterIndexed {index, item -> index % 2 == 0}
    val list4: List<Any?>   = listOf(null, 1, "Adnin", true)
    val list5: List<String> = list4.filterIsInstance<String>()
    val list6: List<Any>    = list4.filterNotNull()

    println(list1)
    println(list2)
    println(list3)
    println(list4)
    println(list5)
    println(list6)
}