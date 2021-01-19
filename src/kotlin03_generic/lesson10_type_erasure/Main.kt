package kotlin03_generic.lesson10_type_erasure

import kotlin03_generic.lesson01_generic.divider

/**
 * Type Erasure
 *
 * - Type erasure adalah proses pengecekan generic pada saat compile
 *   time, dan menghiraukan pengecekan pada saat runtime.
 * - Type erasure menjadikan informasi generic yang kita buat akan
 *   hilang ketika kode program kita telah di compile menjadi binary
 *   file.
 * - Compiler akan mengubah generic parameter type menjadi tipe Any
 *   (atau Object di Java).
 */
class TypeErasure<T>(param: T) {
    /**
     * Ketika dicompile, informasi generic akan hilang
     * dan diubah menjadi Any atau Object di java.
     */
    private val data: T = param
    fun getData(): T  = data
}

fun runTypeErasure() {
    val data = TypeErasure("Adnin")
    val name = data.getData()
}

/**
 * Problem Type Erasure
 *
 * - Karena informasi generic hilang ketika sudah menjadi binary file.
 * - Oleh karena itu, konversi tipe data generic akan berbahaya jika
 *   dilakukan secara tidak bijak.
 */
fun runProblemTypeErasure() {
    val data1 = TypeErasure<String>("Adnin")
    val name: String = data1.getData()

    val dataInt: TypeErasure<Int> = data1 as TypeErasure<Int>
    val name2: Int = dataInt.getData()
}

fun main() {
    divider("Type Erasure", 5)
    runTypeErasure()

    divider("Problem Type Erasure", 4)
    runProblemTypeErasure()
}