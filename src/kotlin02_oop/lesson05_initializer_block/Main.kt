package kotlin02_oop.lesson05_initializer_block

/**
 * Initializer Block
 *
 * - Initializer Block adalah blok kode yang akan dieksekusi
 *   ketika constructor dipanggil.
 * - Kita bisa memasukkan kode program di dalam initializer block.
 *
 * Intermezzo
 *
 * - Kebiasaan dari contructor di bahasa pemrograman yang lain
 *   adalah ketika constructor dibuat, maka blok kode yang ada
 *   di dalam constructor akan dijalankan ketika class dimana
 *   constructor tersebut berada dibuat instancenya atau dibuat
 *   objectnya.
 * - Karena constructor di Kotlin mirip layaknya seperti function,
 *   maka sebagai gantinya untuk menjalankan blok kode ketika
 *   constructor dibuat, Kotlin menggantinya dengan method bernama
 *   init {}
 */
class Person (
    firstName: String = "",
    middleName: String? = null,
    lastName: String = ""
) {
    /**
     * Init akan dieksekusi ketika instance class dibuat
     * atau class ini dibuat objectnya.
     */
    init {
        println("Constructor executed!")
    }

    var firstName: String = firstName
    var middleName: String? = middleName
    var lastName: String = lastName
}

fun main() {
    val person: Person = Person(
        "Adnin",
        "Rifandi Sutanto",
        "Putra"
    )
}
