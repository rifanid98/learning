package kotlin04_collection.lesson25_retrieve_by_position

/**
 * Retrieve by Position
 *
 * - Di kotlin kita bisa mengambil satu element di collection menggunakan posisi.
 */
/*
    Retrieve Operators
    -------------------------------------------------------------------------------
    |           Retrieve Operators        |                Keterangan             |
    -------------------------------------------------------------------------------
    | elementAt(index)                    | Mengambil element pada posisi index.  |
    |-----------------------------------------------------------------------------|
    | first()                             | Mengambil element pertama.            |
    |-----------------------------------------------------------------------------|
    | last()                              | Mengambil element terakhir.           |
    |-----------------------------------------------------------------------------|
    | elementAtOrNull(index)              | Mengambil element pada posisi index.  |
    |                                     | Null jika tidak ada index.            |
    |-----------------------------------------------------------------------------|
    | elementAtOrElse(index, defaultValue)| Mengambil element pada posisi index.  |
    |                                     | Atau default value jika tidak ada     |
    |                                     | index.                                |
    -------------------------------------------------------------------------------
*/
fun main() {
    val list: List<String> = listOf("Adnin", "Rifandi", "Sutanto")
    println(list.first())
    println(list.last())
    println(list.elementAt(0))
    println(list.elementAtOrNull(2))
    println(list.elementAtOrNull(3))
    println(list.elementAtOrElse(2) {""})
    println(list.elementAtOrElse(3) {"Putra"})
}