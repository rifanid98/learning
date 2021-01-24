package kotlin04_collection.lesson33_aggregate

/**
 * Aggregate
 *
 * - Kotlin memiliki berbagai operasi untuk melakukan aggregate.
 */
/*
    Aggregate Operators
    -------------------------------------------------------------------------------
    |   Aggregate Operators  |                      Keterangan                    |
    -------------------------------------------------------------------------------
    | max() dan min()        | Mengambil nilai maksimal dan minimal               |
    |-----------------------------------------------------------------------------|
    | average()              | Mengambil nilai rata-rata                          |
    |-----------------------------------------------------------------------------|
    | sum()                  | Mengambil nilai jumlah seluruh element             |
    |-----------------------------------------------------------------------------|
    | count()                | Mengambil berapa banyak element                    |
    |-----------------------------------------------------------------------------|
    | maxBy(selector)        | Mengambil nilai maksimal dan minimal               |
    | minBy(selector)        |                                                    |
    |-----------------------------------------------------------------------------|
    | maxWith(comparator)    | Mengambil nilai maksimal dan minimum sesuai dengan |
    | minWith(comparator)    | comparatornya                                      |
    |-----------------------------------------------------------------------------|
    | sumBy(selector)        | Mengambil nilai jumlah seluruh element sesuai      |
    |                        | selectornya                                        |
    |-----------------------------------------------------------------------------|
    | sumByDouble(selector)  | Sama dengan sumBy() naum menghasilkan nilai double |
    -------------------------------------------------------------------------------
*/
fun main() {
    val numbers: List<Int> = (1..100).toList()
    println(numbers.max())
    println(numbers.maxOrNull())
    println(numbers.min())
    println(numbers.minOrNull())
    println(numbers.average())
    println(numbers.sum())
    println(numbers.sumBy { number -> number / 2 })
    println(numbers.sumByDouble { number -> number.toDouble() / 2 })
}