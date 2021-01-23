package kotlin04_collection.lesson20_grouping

/**
 *  Grouping
 *
 *  - Grouping adalah operasi untuk meng-grup kan element-element yang ada di
 *    collection.
 */
/*
    Grouping Operators
    -------------------------------------------------------------------------------
    |   Grouping Operators                |                Keterangan             |
    -------------------------------------------------------------------------------
    | groupBy((T) -> K): Map<K, List<T>>  | Menggabungkan collection menjadi group|
    |                                     | Map<K, List<T>>.                      |
    |-----------------------------------------------------------------------------|
    | groupingBy((T) -> K): Grouping<K,T> | Menggabungkan collection menjadi      |
    |                                     | object Grouping<K, T>.                |
    |                                     | *Grouping interface akan dibahas lebih|
    |                                     | detail di materi terpisah.            |
    -------------------------------------------------------------------------------
*/
fun main() {
    val list1: List<String> = listOf("a", "a", "b", "b", "c", "c")
    val map: Map<String, List<String>> = list1.groupBy { item -> item }
    val grouping: Grouping<String, String> = list1.groupingBy { item -> item }

    println(map)
    println(grouping)
}