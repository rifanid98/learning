package kotlin04_collection.lesson18_testing

/**
 * Filtering: Testing
 *
 * - Filtering testing adalah operation yang bisa digunakan untuk mengecek isi
 *   data dari collection.
 * - Hasil dari filtering testing adalah boolean, dimana true jika sesuai kondisi,
 *   dan false jika tidak sesuai kondisi.
 */
/*
    Partitioning Operation
    -------------------------------------------------------------------------------
    |   Partitioning Operation      |                  Keterangan                 |
    -------------------------------------------------------------------------------
    | any((T) -> Boolean): Boolean  | Mengecek apakah minimal ada satu data yang  |
    |                               | sesuai kondisi                              |
    |-----------------------------------------------------------------------------|
    | none((T) -> Boolean): Boolean | Mengecek apakah tidak ada satupun data yang |
    |                               | sesuai dengan kondisi                       |
    |-----------------------------------------------------------------------------|
    | all((T) -> Boolean): Boolean  | Mengecek apakah semua data sesuai dengan    |
    |                               | kondisi                                     |
    |-----------------------------------------------------------------------------|
    | any()                         | Apakah collection memiliki data             |
    |-----------------------------------------------------------------------------|
    | none()                        | Apakah collection tidak memliki data        |
    -------------------------------------------------------------------------------
*/
fun main() {
    val list: List<String> = listOf("Adnin", "Rifandi", "Sutanto")
    println("list.any{}\t: ${list.any {item -> item.length > 5}}")
    println("list.none{}\t: ${list.none {item -> item.length > 5}}")
    println("list.all{}\t: ${list.all {item -> item.length > 5}}")
    println("list.any()\t: ${list.any()}")
    println("list.none()\t: ${list.none()}")
}