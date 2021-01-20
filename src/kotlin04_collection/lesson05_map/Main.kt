package kotlin04_collection.lesson05_map

import kotlin01_fundamental.lesson06_variable.mutable
import kotlin04_collection.lesson01_pengenalan.divider

/**
 * Map
 *
 * - Map (atau dictionary), adalah collection yang berbentuk key-value,
 *   dimana key berperan sebagai index. .
 * - Key harus unik, jika kita menggunakan Key yang sama, maka data
 *   sebelumnya akan di replace oleh data yang baru.
 * - Tipe data key bisa menggunakan tipe data apapun sesuai yang kita
 *   inginkan.
 */
fun runMap() {
    val map: Map<String, Any> = mapOf(
        Pair("name", "Adnin"),
        "age" to 22,
        "married" to false
    )

    println(map.size)
    println(map["name"])
    println(map["age"])
    println(map["married"])

    // cara 1
    for (entry in map) {
        println("${entry.key} to ${entry.value}")
    }
    // cara 2
    //for ((key, value) in map) {
    //    println("$key to $value")
    //}
}

/**
 * Mutable Map
 */
fun runMutableMap() {
    val mutableMap: MutableMap<String, Any> = mutableMapOf(
        Pair("name", "Adnin"),
        "age" to 22
    )
    mutableMap["addres"] = "Kp. Sinagar"
    mutableMap.put("hobby", "Coding")
    mutableMap.putAll(mutableMapOf(
        Pair("stacks", "js, ts, java, go"),
        "job" to "Programmer"
    ))

    // get data
    println("----- get data")
    println(mutableMap.get("name"))
    println(mutableMap.getOrDefault("wife", "jomblo"))

    // cara 1
    println("----- loop 1")
    for (entry in mutableMap) {
        println("${entry.key} to ${entry.value}")
    }
    // cara 2
    println("----- loop 2")
    for ((key, value) in mutableMap) {
        println("$key to $value")
    }
}

fun main() {
    divider("Map", 6)
    runMap()

    divider("Mutable Map", 5)
    runMutableMap()
}