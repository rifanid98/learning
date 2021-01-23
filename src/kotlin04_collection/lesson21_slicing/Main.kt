package kotlin04_collection.lesson21_slicing


/**
 *  Slicing
 *
 *  - Slice adalah operator yang digunakan untuk mengambil sebagian element yang ada
 *    di collection yang sesuai dengan parameter range.
 */
/*
    Slicing Operators
    -------------------------------------------------------------------------------
    |   Slicing Operators   |                       Keterangan                    |
    -------------------------------------------------------------------------------
    | slice(range)          | Mengambil sebagian element yang ada di collection   |
    |                       | yang sesuai dengan index rangenya.                  |
    -------------------------------------------------------------------------------
*/
fun main() {
    val list1: List<Int> = (0..10).toList()
    val list2: List<Int> = list1.slice(0..5)
    val list3: List<Int> = list1.slice(0..10 step 2)
    val list4: List<Int> = list1.slice(10 downTo 0 step 2)

    println(list1)
    println(list2)
    println(list3)
    println(list4)
}