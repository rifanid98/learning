package kotlin04_collection.lesson39_sequence

import kotlin04_collection.lesson01_pengenalan.divider

/**
 * Sequence
 *
 * - Selain List, Set dan Map, di Kotlin juga terdapat collection yang bernama
 *   Sequence.
 * - Sequence sekilas sama dengan collection lain, namun berbeda cara kerjanya
 *   ketika kita menambahkan banyak operasi ke sequence.
 * - Collection lain, ketika kita menambahkan beberapa operasi, semua akan
 *   dieksekusi secara eager. Setiap proses akan mengembalikan collection baru.
 * - Berbeda dengan sequence, sequence mengeksekusi semua operasi secara lazy.
 *   Hanya akan dieksekusi ketika dibutuhkan.
 */
fun runNotSequence() {
    val words: List<String> = "The quick brown fox jumps over the lazy dog".split(" ")
    val lengthList = words
        .filter { word -> println("filter: $word"); word.length > 3 }
        .map { word -> println("length : ${word.length}"); word.length }
        .take(4)

    println("Length of first 4 words longer than 3 chars:")
    println(lengthList)
}

fun runSequence() {
    val words: List<String> = "The quick brown fox jumps over the lazy dog".split(" ")
    val wordsSequence = words.asSequence()

    val lengthSequence = wordsSequence
        .filter { word -> println("filter: $word"); word.length > 3 }
        .map { word -> println("length : ${word.length}"); word.length }
        .take(4)

    println("Length of first 4 words longer than 3 chars:")
    println(lengthSequence.toList())
}

/**
 * Kapan Menggunakan Sequence?
 *
 * - Gunakan ketika :
 *   > Data collection besar.
 *   > Operasi collection kompleks dan banyak.
 *
 * - Jangan gunakan ketika :
 *   > Data collection tidak terlalu besar, karena ada overhead lazy object di
 *     Sequence.
 *   > Operasi yang dilakukan sederhana.
 */
fun main() {
    divider("Not Sequence", 5)
    runNotSequence()

    divider("Sequence", 6)
    runSequence()
}