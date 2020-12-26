package kotlin01_fundamental.lesson28_function_scope

/**
 * Function Scope
 *
 * - Function Scope adalah ruang lingkup dimana sebuah function bisa diakses
 * - Saat kita membuat function di dalam kotlin, maka secara otomatis function
 *   tersebut bisa diakses dari file kotlin manapun
 * - Jika kita ingin membatasi misalnya sebuah function hanya bisa diakses di
 *   function tertentu, maka kita bisa membuat function di dalam function
 */
fun main() {
    fun inner() {
        /* Memanggil outter1() */
        outter1()
    }

    /* Memanggil inner() */
    inner()
}

fun outter1() {
    /* Memanggil outter2() */
    outter2()
    //inner() // ERROR tidak bisa akses
}

fun outter2() {
    println("Ini outter 2")
}