package kotlin04_collection.lesson27_retrieve_by_random

/**
 * Retrieve by Random
 *
 * - Kotlin juga mendukung operasi untuk mengambil element secara random di dalam
 *   collection.
 */
/*
    Retrieve Operators
    -------------------------------------------------------------------------------
    |           Retrieve Operators        |                Keterangan             |
    -------------------------------------------------------------------------------
    | random()                            | Mengambil element secara random       |
    -------------------------------------------------------------------------------
*/
fun main() {
    val range: List<Int> = (1..100).toList()
    println(range.random())
    println(range.random())
    println(range.random())
    println(range.random())
}