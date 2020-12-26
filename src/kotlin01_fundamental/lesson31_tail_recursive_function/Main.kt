package kotlin01_fundamental.lesson31_tail_recursive_function

fun main() {
    display(100)
    display(500)

    println(factorial(1))
    println(factorial(5))
    println(factorial(10))
}

/**
 * Recursive Function
 *
 * - Recursive Function adalah salah satu kemampuan bagus di kotlin, namun
 *   sayangnya ada keterbatasan dalam penggunaan recursive
 * - Jika recursive function yang kita buat, saat dijalankan memanggil dirinya
 *   sendiri terlalu dalam, maka bisa dimungkinkan akan terjadi error stack
 *   overflow
 *
 * Tail Recursive Function
 *
 * - Tail recursive function adalah solusi dari Recursive Function
 * - Tail recursive function adalah teknik mengubah recursive function
 *   yang kita buat, menjadi looping biasa ketika dijalankan
 * - Tidak semua recursive function bisa secara otomatis dibuat menjadi
 *   tail recursive function, ada syarat yang harus dipenuhi
 *
 * Syarat Tail Recursive Function
 *
 * - Tambahkan tailrec di functionnya
 * - Saat memanggil dirinya sendiri, hanya boleh memanggil dirinya sendiri,
 *   tanpa embel-embel operasi dengan data atau function yang lain
 */
tailrec fun display(value: Int) {
    println(value)
    if (value > 0) {
        display(value - 1)
    }
}

tailrec fun factorial(num: Long, total: Long = 1): Long {
    return when(num) {
        1L -> total
        else -> factorial(num - 1, total * num)
    }
}