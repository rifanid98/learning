package kotlin01_fundamental.lesson06_variable

const val NAME: String = "Adnin"

fun main() {
    mutable()
    immutable()
    noDataType()
    nullable()
    constant()
}

fun mutable() {
    /**
     * Mutable Variable
     *
     * Variable yang bisa diubah valuenya
     */
    println("----- Mutable")
    var name: String = "Adnin"
    println("before \t: $name")
    name = "Rifandi"
    println("after \t: $name")
}

fun immutable() {
    /**
     * Immutable Variable
     *
     * Variable yang tidak bisa diubah valuenya
     */
    println("----- Immutable")
    val name: String = "Adnin"
    println(name)
    //name = "Rifandi" // ERROR: immutable
}

fun noDataType() {
    /**
     * Kita bisa membuat variable tanpa
     * mendeklarasikan tipe datanya.
     *
     * Kotlin secara cerdas bisa mendeteksi
     * tipe data yang digunakan bedasarakan
     * valuenya
     */
    var name = "Adnin"  // String
    var age = 22        // int
    var score = 8.5     // float or double
    var married = false // boolean
}

fun nullable() {
    /**
     * Nullable Variable
     *
     * Variable di kotlin harus diisi valuenya.
     * Tapi jika kita ingin dikosongkan valuenya,
     * kotlin bisa menggunakan tanda ? setelah
     * nama variablenya
     */
    println("----- Nullable")
    //var name: String = null   // ERROR
    //var name = null           // tidak diketahui tipe datanya
    var name: String? = null
    println(name)               // null

    /* cara mengakses variable yang kemungkinan null */
    // println(name.length)     // ERROR
    println("length \t: ${name?.length}")
    name = "Adnin"
    println("length \t: ${name?.length}")
}

fun constant() {
    /**
     * Constant
     *
     * Variable yang datanya immutable,
     * yang bisa diakses secara global.
     *
     * Constant dideklarasikan atau di-
     * buat di luar function
     */
    println("----- Constant")
    println("Nama \t: $NAME")
}
