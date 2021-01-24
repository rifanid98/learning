package kotlin04_collection.lesson35_grouping

/**
 * Grouping Interface
 *
 * - Sebelumnya kita sudah bahas tentang operasi Grouping, salah satunya adalah
 *   groupingBy yang menghasilkan object dari interface Grouping.
 */
/*
    Grouping Operators
    -------------------------------------------------------------------------------
    |          Grouping Operators        |               Keterangan               |
    -------------------------------------------------------------------------------
    | eachCount()                        | Menghitung jumlah data di tiap group   |
    |-----------------------------------------------------------------------------|
    | fold() dan reduce()                | Operasi reduce() & fold() di tiap group|
    |-----------------------------------------------------------------------------|
    | aggregate(key: K, accumulator: R?, | Operasi aggregate data di tiap group.  |
    | element: T, first: Boolean)        | Setiap data pertama di masing-masing   |
    |                                    | group, parameter first akan bernilai   |
    |                                    | true, & accumulator akan bernilai null |
    -------------------------------------------------------------------------------
*/
fun main() {
    val list1: List<String> = listOf("a", "a", "b", "b", "c", "c")
    val grouping: Grouping<String, String> = list1.groupingBy { item -> item }
    println(grouping)
    println(grouping.eachCount())
    println(grouping.fold("") {current, next -> current + next })
    println(grouping.reduce {key, current, next -> current + next})
    println(grouping.aggregate { key, current: String?, next, first ->
        if (first) next
        else current + next
    })
}