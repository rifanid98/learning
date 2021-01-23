package kotlin04_collection.lesson22_take_and_drop

import kotlin04_collection.lesson01_pengenalan.divider

/**
 * Take & Drop Operators
 *
 * - Untuk mengambil sebagian element di collection, selain menggunakan slice,
 *   kita juga bisa menggunakan operator take dan drop.
 */
/*
    Take Operators
    -------------------------------------------------------------------------------
    |         Take Operators        |                 Keterangan                  |
    -------------------------------------------------------------------------------
    | take(n)                       | Mengambil collection di awal sejumlah n.    |
    |-----------------------------------------------------------------------------|
    | takeLast(n)                   | Mengambil collection di akhir sejumlah n.   |
    |-----------------------------------------------------------------------------|
    | takeWhile((T) -> Boolean)     | Mengambil element dari awal selama kondisi  |
    |                               | bernilai true, jika false, maka berhenti.   |
    |-----------------------------------------------------------------------------|
    | takeWhileLast((T) -> Boolean) | Sama seperti takeWhile, namun dimulai dari  |
    |                               | element akhir.                              |
    -------------------------------------------------------------------------------
*/
fun runTake() {
    val chars: List<Char> = ('a'..'z').toList()

    println(chars.take(3))
    println(chars.takeWhile { char -> char < 'f' })
    println(chars.takeLast(3))
    println(chars.takeLastWhile { char -> char > 'w' })
}

/*
    Drop Operators
    -------------------------------------------------------------------------------
    |         Drop Operators        |                 Keterangan                  |
    -------------------------------------------------------------------------------
    | drop(n)                       | Menghapus collection di awal sejumlah n.    |
    |-----------------------------------------------------------------------------|
    | dropLast(n)                   | Menghapus collection di akhir sejumlah n.   |
    |-----------------------------------------------------------------------------|
    | dropWhile((T) -> Boolean)     | Menghapus element dari awal selama kondisi  |
    |                               | bernilai true, jika false, maka berhenti.   |
    |-----------------------------------------------------------------------------|
    | dropWhileLast((T) -> Boolean) | Sama seperti dropWhile, namun dimulai dari  |
    |                               | element akhir.                              |
    -------------------------------------------------------------------------------
*/
fun runDrop() {
    val chars: List<Char> = ('a'..'z').toList()

    println(chars.drop(23))
    println(chars.dropWhile { char -> char < 'x' })
    println(chars.dropLast(23))
    println(chars.dropLastWhile { char -> char > 'c' })
}

fun main() {
    divider("Take Operator", 5)
    runTake()

    divider("Drop Operator", 5)
    runDrop()
}