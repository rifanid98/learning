package kotlin04_collection.lesson17_partitioning

/**
 * Filtering: Partitioning
 *
 * - Pada filtering by predicate, kita akan menghilangkan data yang tidak masuk
 *   kondisi filter.
 * - Dengan filtering partition, kita akan membagi collection menjadi dua, dimana
 *   collection pertama yang masuk filtering, dan collection kedua yang tidak
 *   masuk filtering.
 */
/*
    Partitioning Operation
    -------------------------------------------------------------------------------
    |   Partitioning Operation             |               Keterangan             |
    -------------------------------------------------------------------------------
    | partition((T) -> Boolean):           | Mempartisi collection dengan filter- |
    | Pair<List<T>, List<T>>               | ing sehingga menghasilkan Pair coll- |
    |                                      | ection T yang mamsuk filter, dan     |
    |                                      | collection T yang tidak masuk filter |
    -------------------------------------------------------------------------------
*/
fun main() {
    val list1: List<String> = listOf("Adnin", "Rifandi", "Sutanto")
    val list2: Pair<List<String>, List<String>> = list1.partition { item -> item.length > 5 }
    val (match, unmatch) = list2

    println(list1)
    println(list2)
    println(match)
    println(unmatch)
}