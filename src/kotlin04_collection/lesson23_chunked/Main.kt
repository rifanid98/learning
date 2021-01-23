package kotlin04_collection.lesson23_chunked


/**
 * Chunked Operators
 *
 * - Chunked adalah operasi untuk memotong collection menjadi beberapa collection.
 */
/*
    Chunked Operators
    -------------------------------------------------------------------------------
    |        Chunked Operators      |                 Keterangan                  |
    -------------------------------------------------------------------------------
    | chunked(n): List<List<T>>     | Memotong collection menjadi beberapa        |
    |                               | collection dengan jumlah data n.            |
    |-----------------------------------------------------------------------------|
    | chunked(n, (List<T>) -> R):   | Memotong collection menjadi beberapa        |
    | List<R>                       | collection dengan jumlah data n, lalu       |
    |                               | melakukan transformasi List<T> menjadi R,   |
    |                               | sehingga menghasilkan List<R>               |
    -------------------------------------------------------------------------------
*/
fun main() {
    val range: List<Int> = (1..100).toList()
    val list1 = range.chunked(10)
    val list2 = range.chunked(10) {list: List<Int> ->
        var total = 0
        for (number in list) {
            total += number
        }
        total
    }

    println(list1)
    println(list2)

    /**
     * List 2 Manual with .map()
     */
    val list3 = range.chunked(10).map { values ->
        var total = 0
        for (value in values) {
            total += value
        }
        total
    }
    println(list3)
}