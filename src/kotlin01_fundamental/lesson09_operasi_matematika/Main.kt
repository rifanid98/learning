package kotlin01_fundamental.lesson09_operasi_matematika

fun main() {
    mathematic()
    augmentedAssignments()
    unaryOperator()
}

fun mathematic() {
    /**
     * Kotlin sudah mendukung semua
     * operasi matematika _, -, /, *
     *
     * Operasi matematika sudah sciencetific,
     * apabila ada pembagian dan penjumlahan
     * makan didahulukan pembagian lalu pen-
     * jumlahan
     */
    var result1: Int = 10 / 3
    println(result1) // 3

    var result2: Float = 10F / 3F
    println(result2) // 3.3
}

fun augmentedAssignments() {
    /* From */
    var n1: Int = 10;

    n1 = n1 + 10
    n1 = n1 - 10
    n1 = n1 / 10
    n1 = n1 * 10

    /* To */
    var n2: Int = 10;

    n2 += 10
    n2 -= 10
    n2 /= 10
    n2 *= 10
}

fun unaryOperator() {
    var n = 10;

    n++;    // 11 (n += 1)
    n--;    // 10 (n -= 1)
    -n;     // -10 (negative)
    +n;     // 10 (positive)

    /* Nilai kebalikan dari boolean */
    var b = true;
    !b;     // false
}