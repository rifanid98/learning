package kotlin04_collection.lesson14_flattening

import kotlin04_collection.lesson01_pengenalan.divider

/**
 * Transformations: Flattening
 *
 * - Flattening adalah operasi transformasi untuk menjadikan nested collection
 *   menjadi flat.
 */
/*
    Flattening Operations
    ----------------------------------------------------------------------------
    |   Flattening Operations     |                 Keterangan                 |
    ----------------------------------------------------------------------------
    | flatten                     | Mengubah nested collection menjadi flat    |
    |                             | collection (dari 2D menjadi 1D)            |
    |--------------------------------------------------------------------------|
    | flatMap((T) -> Iterable<R>) | Mengubah collection T menjadi flat         |
    |                             | collection R                               |
    ----------------------------------------------------------------------------
 */
fun runFlatten() {
    val list1: List<List<String>> = listOf(
        listOf("Adnin", "Rifandi"),
        listOf("Sutanto", "Putra")
    )
    val list2: List<String> = list1.flatten()

    println("From\t: $list1")
    println("To\t\t: $list2")
}

class Member(val name: String, val hobbies: List<String>)

fun runFlatMap() {
    val members: List<Member> = listOf(
        Member("Adnin", listOf("Learning", "Coding")),
        Member("Abu", listOf("Playing", "Working"))
    )
    val hobbiesMap: List<List<String>> = members.map { member -> member.hobbies }
    val hobbiesFlatten: List<String> = members.map { member -> member.hobbies  }.flatten()

    val hobbiesFlatMap: List<String> = members.flatMap { member: Member -> member.hobbies }

    println("----- Manual Flatten Map")
    println("From\t:$hobbiesMap")
    println("To\t\t:$hobbiesFlatten")

    println("----- Otomatis FlatMap")
    println(hobbiesFlatMap)
}

fun main() {
    divider("Flatten", 6)
    runFlatten()

    divider("Flat Map", 5)
    runFlatMap()
}