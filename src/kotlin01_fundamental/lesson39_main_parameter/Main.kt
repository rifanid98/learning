package kotlin01_fundamental.lesson39_main_parameter

/**
 * Main Parameters
 *
 * - Kadang saat menjalankan program, kita butuh parameter dari luar.
 * - Bisa untuk konfigurasi program atau yang lainnya.
 * - Kotlin mendukung parameter untuk main function.
 */
fun main(args: Array<String>) {
    for (value in args) {
        println(value)
    }
}