package kotlin04_collection.lesson13_association

/**
 * Transformations: Association
 *
 * - Association adalah operasi transformasi dari collection menjadi map.
 * - Dalam beberapa operasi association, element hasil bisa menjadi key atau value.
 */
/*
    Association Operations
    ----------------------------------------------------------------------------
    |   Association Operations    |                 Keterangan                 |
    ----------------------------------------------------------------------------
    | associate((T) -> Pair<K,V>) | Mengubah collection T menjadi Map<K, V>    |
    |--------------------------------------------------------------------------|
    | associateWith(T -> V)       | Mengubah collection T menjadi Map<T, V>    |
    |--------------------------------------------------------------------------|
    | associateBy(T -> K)         | Mengubah collection T menjadi Map<K, T>    |
    ----------------------------------------------------------------------------
 */
fun main() {
    val list1: List<String> = listOf("Adnin", "Rifandi", "Sutanto")
    val map1: Map<String, Int> = list1.associate { item -> Pair(item, item.length) }
    val map2: Map<String, Int> = list1.associateWith { item -> item.length  }
    val map3: Map<Int, String> = list1.associateBy { item -> item.length }

    println(map1)
    println(map2)
    println(map3)
}