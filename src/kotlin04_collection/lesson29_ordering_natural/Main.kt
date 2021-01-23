package kotlin04_collection.lesson29_ordering_natural

/**
 * Ordering: Natural
 *
 * - Mengurutkan data sudah menjadi salah satu kebiasaan yang kita lakukan saat
 *   membuat program.
 * - Kotlin mendukung operasi untuk mengurutkan collection.
 * - Pada materi Kotlin Generic kita sudah belajar tentang interface Comparable,
 *   yaitu interface yang digunakan untuk melakukan perbandingan dua buat object,
 *   yang biasanya digunakan untuk mengurutkan data.
 * - Secara default tipe data yang ada di kotlin sudah memiliki Comparable (seperti
 *   Number, Char atau String). Oleh karena itu kita tidak perlu lagi membuat
 *   Comparable sendiri untuk mengurutkan data tersebut.
 */
/*
    Ordering Operators
    -------------------------------------------------------------------------------
    |    Ordering Operators    |                     Keterangan                   |
    -------------------------------------------------------------------------------
    | sorted()                 | Mengurutkan collection secara ascending          |
    |-----------------------------------------------------------------------------|
    | sortedDescending()       | Mengecek apakah terdapat element                 |
    -------------------------------------------------------------------------------
*/
fun main() {
    val numbers: List<Int> = listOf(1,3,2,4,6,3,5)
    println(numbers.sorted())
    println(numbers.sortedDescending())
}