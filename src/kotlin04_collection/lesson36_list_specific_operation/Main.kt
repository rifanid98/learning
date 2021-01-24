package kotlin04_collection.lesson36_list_specific_operation

import kotlin04_collection.lesson01_pengenalan.divider

/**
 * List Specific Operation
 *
 * - Di kotlin ada banyak operasi yang khusus dibuat untuk List.
 */
/*
    List Specific Operators 1
    -------------------------------------------------------------------------------
    |     List Specific Operators    |                  Keterangan                |
    -------------------------------------------------------------------------------
    | getOrElse(index, (index) -> T) | Mengambil element di index, jika tidak ada,|
    |                                | maka akan mengembalikan nilai lambda       |
    |-----------------------------------------------------------------------------|
    | getOrNull(index)               | Mengambil element di index, jika tidak ada,|
    |                                | maka akan mengembalikan nilai null         |
    |-----------------------------------------------------------------------------|
    | subList(from, to)              | Mengambil semua element dari from          |
    |                                | (inclusive) ke to (exclusive)              |
    |-----------------------------------------------------------------------------|
    | binarySearch(value)            | Melakukan pencarian menggunakan algoritma  |
    |                                | binary search                              |
    |-----------------------------------------------------------------------------|
    | binarySearch(value)            | Menghitung jumlah data di tiap group   |
    |-----------------------------------------------------------------------------|
    | binarySearch(value)            | Menghitung jumlah data di tiap group   |
    |-----------------------------------------------------------------------------|
    | binarySearch(value)            | Menghitung jumlah data di tiap group   |
    |-----------------------------------------------------------------------------|
    | binarySearch(value)            | Menghitung jumlah data di tiap group   |
    -------------------------------------------------------------------------------
*/
fun runListSpecificOperator1() {
    val names: List<String> = listOf("Adnin", "Rifandi", "Sutanto")
    val getOrNull = names.getOrNull(1)
    val getOrElse = names.getOrElse(5) { name -> "404" }
    val subList   = names.subList(0, 2)

    val list2: List<String> = names.sorted()
    val binarySearch        = list2.binarySearch("Sutanto")

    println("names.getOrNull()\t: $getOrNull")
    println("names.getOrElse()\t: ${getOrElse}")
    println("names.subList()\t\t: ${subList}")
    println("names.binarySearch(): ${binarySearch}")
}

/*
    List Specific Operators 2
    -------------------------------------------------------------------------------
    |     List Specific Operators    |                  Keterangan                |
    -------------------------------------------------------------------------------
    | indexOf(value)                 | Mengambil index element yang sama dengan   |
    |                                | value                                      |
    |-----------------------------------------------------------------------------|
    | lastIndexOf(value)             | Mengambil index element terakhir yang sama |
    |                                | value                                      |
    |-----------------------------------------------------------------------------|
    | indexOfFirst((T) -> Boolean)   | Mengambil index element yang sama dengan   |
    |                                | kondisi                                    |
    |-----------------------------------------------------------------------------|
    | indexOfLast((T) -> Boolean)    | Mengambil index element terakhir yang sama |
    |                                | dengan kondisi                             |
    -------------------------------------------------------------------------------
*/
fun runListSpecificOperator2() {
    val numbers: List<Int> = listOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)
    val indexOf = numbers.indexOf(2)
    val lastIndexOf = numbers.lastIndexOf(3)
    val indexOfFirst = numbers.indexOfFirst { number -> number > 3}
    val indexOfLast = numbers.indexOfLast { number -> number > 3}

    println("members.indexOf()\t\t: $indexOf")
    println("members.lastIndexOf()\t: $lastIndexOf")
    println("members.indexOfFirst()\t: $indexOfFirst")
    println("members.indexOfLast()\t: $indexOfLast")
}

fun main() {
    divider("List Specific Operator 1", 4)
    runListSpecificOperator1()

    divider("List Specific Operator 1", 4)
    runListSpecificOperator2()
}