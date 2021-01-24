package kotlin04_collection.lesson34_fold_reduce

/**
 * Fold & Reduce
 *
 * - Jika kita ingin membuat aggregate secara manual, kita bisa menggunakan
 *   operator fold dan reduce.
 * - Fold dan reduce merupakan operasi yang dilakukan pada element-element yang
 *   ada di collection secara iterasi sequential dan mengembalikan hasil.
 * - Hasil dari fold dan reduce akan digunakan untuk iterasi selanjutnya.
 */
/*
    Fold & Reduce Operators
    -------------------------------------------------------------------------------
    |      Fold & Reduce Operators    |                 Keterangan                |
    -------------------------------------------------------------------------------
    | reduce((R, T) -> R): R          | Pada iterasi pertama, R adalah element    |
    |                                 | pertama, T adalah element selanjutnya.    |
    |                                 | Iterasi selanjutnya, R adalah hasil dari  |
    |                                 | iterasi sebelumnya                        |
    |-----------------------------------------------------------------------------|
    | fold(R, (R, T) -> R): R         | Fold sama dengan reuce, yang membedakan   |
    |                                 | adalah, fold memiliki inisial value R     |
    |                                 | yang bisa kita masukkan secara manual     |
    |-----------------------------------------------------------------------------|
    | reduceRight() & foldRight()     | Sama seperti reduce() dan fold() namun    |
    |                                 | dimulai dari element akhir                |
    |-----------------------------------------------------------------------------|
    | reduceIndexed() & foldIndexed() | Sama seperti reduce() dan fold() namun    |
    |                                 | terdapat parameter index                  |
    |-----------------------------------------------------------------------------|
    | reduceRightIndexed()            | Sama seperti reduceIndexed() dan          |
    | foldRightIndexed()              | foldIndexed() namun dimulai dari element  |
    |                                 | akhir                                     |
    -------------------------------------------------------------------------------
*/
fun main() {
    val numbers: List<Int> = (1..100).toList()
    val max: Int = numbers.reduce { current, next ->
        if (current < next) next
        else  current
    }
    val min: Int = numbers.reduce { current, next ->
        if (current < next ) current
        else  next
    }
    val sum: Int = numbers.fold(0) { current, next ->
        current + next
    }
    val count: Int = numbers.fold(0) { current, next ->
        current + 1
    }

    println(max)
    println(min)
    println(sum)
    println(count)
}