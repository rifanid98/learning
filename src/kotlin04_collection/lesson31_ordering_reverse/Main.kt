package kotlin04_collection.lesson31_ordering_reverse

/**
 * Ordering: Reverse
 *
 * - Di Kotlin, kita bisa mendapatkan collection dengan urutan data terbalik
 *   dari data aslinya.
 */
/*
    Ordering Operators
    -------------------------------------------------------------------------------
    |    Ordering Operators  |              Keterangan             |
    -------------------------------------------------------------------------------
    | reversed()             | Membuat collection baru dengan urutan terbalik     |
    |                        | dari collection aslinya                            |
    |-----------------------------------------------------------------------------|
    | asReversedDescending() | Membuat view terhadap collection dengan urutan     |
    |                        | terbalik, jika collection aslinya berubah, viewpun |
    |                        | akan berubah                                       |
    -------------------------------------------------------------------------------
*/
fun main() {
    val list1: MutableList<String> = mutableListOf("Adnin", "Rifandi", "Sutanto")
    val listReverse: List<String> = list1.reversed()
    val listAsReverse: List<String> = list1.asReversed()

    println("----- Before Added")
    println("List\t: $list1")
    println("List Reverse\t: $listReverse")
    println("List As Reverse\t: $listAsReverse")
    println("----- After Added")
    list1.add("Putra")
    println("List\t: $list1")
    println("List Reverse\t: $listReverse")
    println("List As Reverse\t: $listAsReverse")
}