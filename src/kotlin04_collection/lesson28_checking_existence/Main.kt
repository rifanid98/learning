package kotlin04_collection.lesson28_checking_existence

/**
 * Checking Existence
 *
 * - Kotlin mendukung operasi untuk mengecek apakah dalam collection terdapat
 *   data yang kita cari.
 */
/*
    Checking Existence Operators
    -------------------------------------------------------------------------------
    |     Checking Existence Operators    |                Keterangan             |
    -------------------------------------------------------------------------------
    | contains(element): Boolean          | Mengecek apakah terdapat element di   |
    |                                     | collection                            |
    |-----------------------------------------------------------------------------|
    | containsAll(Collection<T>): Boolean | Mengecek apakah terdapat element      |
    |                                     | collection T di collection            |
    |-----------------------------------------------------------------------------|
    | isEmpty(): Boolean                  | Mengecek apakah collection kosong     |
    |-----------------------------------------------------------------------------|
    | isNotEmpty(): Boolean               | Mengecek apakah collection tidak      |
    |                                     | kosong                                |
    -------------------------------------------------------------------------------
*/
fun main() {
    val range: List<Int> = (1..10).toList()
    println(range.contains(5))
    println(range.containsAll(listOf(3,4,5)))
    println(range.isEmpty())
    println(range.isNotEmpty())
}