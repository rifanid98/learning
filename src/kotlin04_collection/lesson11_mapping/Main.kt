package kotlin04_collection.lesson11_mapping

import kotlin04_collection.lesson01_pengenalan.divider

/**
 * Transformations: Mapping
 *
 * - Transformasi mapping digunakan untuk mengubah data ke data lain.
 * - Mapping akan membutuhkan lambda function sebagai parameter, dan akan
 *   mengembalikan collection hasil result lambda nya.
 * - Urutan collection baru hasil dari mapping adalah sama dengan urutan
 *   collection aslinya.
 */
/*
    Mapping Operations 1
    ---------------------------------------------------------------------------
    |          Mapping Operations             |          Keterangan           |
    ---------------------------------------------------------------------------
    | map(transform: (T) -> R)                | Mengubah collection menjadi   |
    |                                         | collection baru sesuai lambda |
    |                                         | transformnya.                 |
    |-------------------------------------------------------------------------|
    | mapIndexed(transformL (index, T) -> R)  | Mengubah collection mejadi    |
    |                                         | collection baru, dengan tamba-|
    |                                         | han parameter index.          |
    |-------------------------------------------------------------------------|
    | mapNotNull(transform: (T) -> R)         | Sama seperti map(), namun meng|
    |                                         | hiraukan hasil null.          |
    |-------------------------------------------------------------------------|
    | mapIndexedNotNull(transform: (index, T) | Sama seperti mapIndexed(), na-|
    | -> R)                                   | mun menghiraukan nilai null.  |
    ---------------------------------------------------------------------------
 */
fun runMappingOperations1() {
    /**
     * Manual
     */
    divider("Manual", 6)
    val list: List<String> = listOf("Adnin", "Rifandi", "Sutanto")
    val temp: MutableList<String> = mutableListOf()
    for (value in list) {
        temp.add(value.toUpperCase())
    }
    println(list.toString())
    println(temp.toString())

    /**
     * Otomatis, menggunakan fitur extension function .map()
     */
    divider("Otomatis", 6)
    val list1: List<String> = listOf("Adnin", "Rifandi", "Sutanto")
    val list2: List<String> = list1.map { item -> item.toUpperCase() }
    val list3: List<Int>    = list1.map { it.length }
    val list4: List<String> = list1.mapNotNull { value ->
        if (value == "Adnin") value else null
    }
    val list5: List<String> = list1.mapIndexedNotNull {index, name ->
        if (index % 2 == 0) null
        else name
    }
    val rangeList: List<Int> = (1..10).toList()
    val list6 = rangeList.mapNotNull {
        if (it % 2 == 0) null
        else it
    }

    println(list1.toString())
    println(list2.toString())
    println(list3.toString())
    println(list4.toString())
    println(list5.toString())
    println(list6.toString())
}

/*
    Mapping Operations 2
    ---------------------------------------------------------------------------
    |          Mapping Operations             |          Keterangan           |
    ---------------------------------------------------------------------------
    | mapKeys(transform: (Entry<K, V>) -> R)  | Mengubah map menjadi map baru |
    |                                         | dengan nilai key baru sesuai  |
    |                                         | dengan lambda transformnya.   |
    |-------------------------------------------------------------------------|
    | mapValues(transform: (Entry<K,V>) -> R) | Mengubah map menjadi map baru |
    |                                         | dengan nilai value baru sesuai|
    |                                         | dengan lambda transformnya.   |
    ---------------------------------------------------------------------------
 */
fun runMappingOperations2() {
    val map1: Map<Int, String> = mapOf(
        1 to "Adnin",
        2 to "Rifandi",
        3 to "Sutanto",
    )
    val map2: Map<Int, String> = map1.mapKeys { it.key*2 }
    val map3: Map<Int, String> = map1.mapValues { it.value.toUpperCase() }

    println(map2)
    println(map3)
}

fun main() {
    divider("Mapping Operations 1", 4)
    runMappingOperations1()

    divider("Mapping Operations 2", 4)
    runMappingOperations2()
}