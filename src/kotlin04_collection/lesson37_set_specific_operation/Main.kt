package kotlin04_collection.lesson37_set_specific_operation

/**
 * Set Specific Operation
 *
 * - Di kotlin juga terdapat operations yang khusus digunakan untuk Set.
 */
/*
    Set Specific Operators 1
    -------------------------------------------------------------------------------
    |     Set Specific Operators     |                  Keterangan                |
    -------------------------------------------------------------------------------
    | union(collection)              | Mengembalikan semua element dari kedua set |
    |-----------------------------------------------------------------------------|
    | intersect(collection)          | Mengembalikan semua element yang terdapat  |
    |                                | di kedua set                               |
    |-----------------------------------------------------------------------------|
    | substract(collection)          | Mengembalikan semua element yang dimiliki  |
    |                                | set pertama namun tidak dimiliki oleh set  |
    |                                | kedua                                      |
    -------------------------------------------------------------------------------
*/
fun main() {
    val numbers1: Set<Int> = (1..10).toSet()
    val numbers2: Set<Int> = (6..15).toSet()

    val union: Set<Int>     = numbers1 union numbers2
    val intersect: Set<Int> = numbers1 intersect numbers2
    val substract: Set<Int> = numbers1 subtract numbers2

    println("Union\t\t: $union")
    println("Intersect\t: $intersect")
    println("Substract\t: $substract")
}