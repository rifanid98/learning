package kotlin04_collection.lesson02_list

import kotlin04_collection.lesson01_pengenalan.divider

/**
 * List
 *
 * - List, adalah collection yang datanya seperti Array dan memiliki akses
 *   data menggunakan index .
 * - Data di List boleh duplicate, artinya kita boleh memasukkan data yang
 *   sama berkali-kali ke dalam sebuah List yang sama.
 */

fun runList() {
    val list: List<String> = listOf("Adnin", "Rifandi")
    println(list[0])
    println(list[1])
    println(list.isEmpty())
    println(list.indexOf("Rifandi"))
    println(list.contains("Adnin"))
}

fun runMutableList() {
    val mutableList: MutableList<String> = mutableListOf("Adnin")
    mutableList.add("Rifandi")
    mutableList.add("Sutanto")
    println(mutableList[0])

    for (value in mutableList) {
        println(value)
    }

    println(mutableList.isEmpty())
    println(mutableList.indexOf("Rifandi"))
    println(mutableList.contains("Adnin"))
}

fun main() {
    divider("List", 6)
    runList()

    divider("Mutable List", 5)
    runMutableList()
}