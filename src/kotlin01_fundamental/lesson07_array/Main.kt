package kotlin01_fundamental.lesson07_array

fun main() {
    /**
     * Nilai pada array di kotlin selalu sama
     * Tidak bisa memiliki value dengan tipe
     * data yang berbeda
     */
    array()
    arrayNullable()
}

fun array() {
    println("----- Array")
    /* Deklarasi Array */
    val names: Array<String> = arrayOf("Adnin", "Rifandi", "Sutanto", "Putra")
    val numbers: Array<Int> = arrayOf(1, 2, 3, 4)
    val prices: Array<Int> = arrayOf(1_000, 2_000, 3_000, 4_000)

    /* Mengambil Element Array */
    println(names.size)   // get array length

    println(names.get(0)) // get element at index
    names.set(0, "ADNIN") // set element at index
    println(names.get(0)) // get element at index

    println(names[0])     // get element at index
    names[0] = "Adnin"    // set element at index
    println(names[0])     // get element at index
}

fun arrayNullable() {
    println("----- Array Nullable")
    /* Gunakan tanda ? untuk membuat array nullable */
    val names: Array<String?> = arrayOfNulls(4)
    names[0] = "Adnin"
    names[1] = null
    names[2] = "Sutanto"
    names[3] = null

    println(names.toString())
}