package kotlin01_fundamental.lesson10_operasi_perbandingan

fun main() {
    /**
     * Operasi perbandingan akan selalu
     * menghasilkan nilai booelan, true/
     * false
     *
     * Operator Perbandingan yang ada di
     * kotlin:
     * >
     * <
     * >=
     * <=
     * ==
     * !=
     */
    val a = 10
    val b = 20

    /* Penggunaan dengan variable */
    val result: Boolean = a != b

    println(a > b)  // false
    println(a < b)  // true
    println(a >= b) // false
    println(a <= b) // true
    println(a == b) // false
    println(a != b) // true
}