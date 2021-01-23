package kotlin04_collection.lesson24_windowed

/**
 * Windowed Operation
 *
 * - Windowed adalah operasi untuk mendapatkan semua kemungkinan collection sesuai
 *   dengan range yang telah ditentukan.
 */
/*
    Windowed Operators
    -------------------------------------------------------------------------------
    |           Windowed Operators        |                Keterangan             |
    -------------------------------------------------------------------------------
    | windowed(size, step, partialWindow) | Mengambil semua kemungkinan collection|
    |                                     | sebesar size, dilanjut dengan step, & |
    |                                     | dan diakhiri dengan partialWindow     |
    |-----------------------------------------------------------------------------|
    | windowed(size, step, partialWindow, | Sama seperti windowed() sebelumnya,   |
    | transform)                          | namun hasil collectionnya di transform|
    -------------------------------------------------------------------------------
*/
fun main() {
    val range: List<Int> = (1..5).toList()
    println(range.windowed(3, 1, false))
    println(range.windowed(3, 1, false) {item -> item.size})
    println(range.windowed(3, 1, true))
    println(range.windowed(3, 1, true) {item -> item.size})
    println(range.windowed(3, 2, false))
    println(range.windowed(3, 2, true))
}