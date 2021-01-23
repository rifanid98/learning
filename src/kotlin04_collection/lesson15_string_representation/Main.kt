package kotlin04_collection.lesson15_string_representation

import java.lang.StringBuilder

/**
 * Transformations: String Representation
 *
 * - String Representations adalah operasi transformasi untuk mengubah collection
 *   menjadi string.
 */
/*
    String Representation Operations
    -------------------------------------------------------------------------------
    |   String Representation Operations     |                 Keterangan         |
    -------------------------------------------------------------------------------
    | joinToString(separator, prefix, suffix | Mengubah collection menjadi string |
    |                                        | dengan separator, prefix & suffix. |
    |-----------------------------------------------------------------------------|
    | joinToString(separator, prefix, suffix,| Mengubah collection menjadi string |
    | transform)                             | dengan separator, prefix & suffix, |
    |                                        | namun akan diubah dalam transform  |
    |                                        | terlebih dahulu.                   |
    |-----------------------------------------------------------------------------|
    | jointTo(Appendable, separator, prefix, | Sama seperti joinToString, namun   |
    | suffix, transform)                     | string ditambahkan ke Appendable   |
    -------------------------------------------------------------------------------
 */
fun main() {
    val names: List<String> = listOf("Adnin", "Rifandi", "Sutanto")
    println(names.joinToString(" ", "|", "|"))
    println(names.joinToString(", ", "|", "|") { string -> "Item $string" })

    val appendable: StringBuilder = StringBuilder()
    names.joinTo(appendable, ",", "|", "|") { string -> string }
    println(appendable.toString())
}