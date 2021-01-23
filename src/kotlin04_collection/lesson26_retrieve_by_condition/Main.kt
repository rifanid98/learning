package kotlin04_collection.lesson26_retrieve_by_condition

/**
 * Retrieve by Condition
 *
 * - Selain mengambil satu element di collection berdasarkan posisi, kita juga
 *   bisa mengambil single element berdasarkan kondisi.
 */
/*
    Retrieve Operators
    -------------------------------------------------------------------------------
    |           Retrieve Operators        |                Keterangan             |
    -------------------------------------------------------------------------------
    |-----------------------------------------------------------------------------|
    | first((T) -> Boolean)               | Mengambil element pertama yang sesuai |
    |-----------------------------------------------------------------------------|
    | last((T) -> Boolean)                | Mengambil element terakhir yang sesuai|
    |                                     | dengan kondisi                        |
    |-----------------------------------------------------------------------------|
    | firstOrNull((T) -> Boolean) / find()| Mengambil element pertama yang sesuai |
    |                                     | kondisi, atau null jika tidak ada     |
    |-----------------------------------------------------------------------------|
    | lastOrNull((T) -> Boolean) /        | Mengambil element terakhir yang sesuai|
    | findLast()                          | kondisi, atau null jika tidak ada     |
    -------------------------------------------------------------------------------
*/
fun main() {
    val list: List<Int> = (1..20).toList()
    println(list.first { item -> item > 10 })
    println(list.last { item -> item > 10 })
    println(list.firstOrNull { item -> item > 50 })
    println(list.lastOrNull { item -> item > 50 })
    println(list.find { item -> item > 50 })
    println(list.findLast { item -> item > 50 })
}