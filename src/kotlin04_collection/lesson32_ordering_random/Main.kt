package kotlin04_collection.lesson32_ordering_random

/**
 * Ordering: Random
 *
 * - Di Kotlin, kita juga bisa mengacak isi element di collection.
 */
/*
    Ordering Operators
    -------------------------------------------------------------------------------
    |    Ordering Operators  |                      Keterangan                    |
    -------------------------------------------------------------------------------
    | shuffled()           | Membuat collection baru dengan posisi element random |
    -------------------------------------------------------------------------------
*/
fun main() {
    val numbers: List<Int> = (1..10).toList()
    println(numbers.shuffled())
    println(numbers.shuffled())
    println(numbers.shuffled())
    println(numbers.shuffled())
}