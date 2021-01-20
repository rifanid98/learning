package kotlin03_generic.lesson15_generic_extension_function

/**
 * Generic Extension Function
 *
 * - Generic juga bisa digunakan pada extension function.
 * - Dengan begitu kita bisa memilih jenis generic parameter type apa
 *   yang bisa menggunakan extension function tersebut.
 */
class Data<T>(val data: T)

fun Data<String>.print() {
    val string: String = this.data
    println("String value is $string")
}

fun main() {
    val data1: Data<Int> = Data(1)
    val data2: Data<String> = Data("Adnin")

    //data1.print() // ERROR
    data2.print()
}