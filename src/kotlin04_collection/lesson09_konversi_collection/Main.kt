package kotlin04_collection.lesson09_konversi_collection

import java.util.SortedSet

/**
 * Konversi Collection
 *
 * - Di kotlin kita bisa melakukan konversi collection ke jenis
 *   collection lain secara mudah.
 * - Misal kita ingin mengubah dari array ke list, atau dari range ke
 *   set, atau dari set ke list, bisa dilakukan dengan mudah.
 * - Semua function dimulai dengan kata “to”, misal toList, toSet,
 *   toMutableList, dan lain-lain.
 */
fun main() {

    //source
    val range: IntRange = 1..100
    val array: Array<Int> = arrayOf(1,2,3,4,5)

    // list
    val list: List<Int> = range.toList()
    val mutableList: MutableList<Int> = array.toMutableList()

    // set
    val set: Set<Int> = list.toSet()
    val mutableSet: MutableSet<Int> = list.toMutableSet()
    val sortedSet: SortedSet<Int> = list.toSortedSet()

}