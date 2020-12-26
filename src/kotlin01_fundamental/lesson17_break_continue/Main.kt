package kotlin01_fundamental.lesson17_break_continue

/**
 * Break Continue
 */
fun main() {
    /**
     * Break digunakan untuk menghentikan
     * seluruh perulangan. Apabila kita
     * menggunakan break, maka eksekusi
     * perulangan akan dihentikan
      */
    println("----- Break")
    var i: Int = 0
    while (true) {
        println(i)
        i++

        if (i >= 10) {
            /* apabila i sudah mencapai nilai lebih dari 10 */
            /* maka perulangan akan dihentikan, jika tidak, */
            /* maka akan dilanjutkan */
            break
        }
    }
    /**
     * Continue digunakan untuk melanjutkan
     * step perulangan atau lebih tepatnya
     * seperti meng-skip step perulangan
     * ketika sudah mencapai kondisi tertentu
     */
    println("----- Continue")
    for (i: Int in 0..20) {
        if (i % 2 == 0) {
            /* Jika i adalah bilangan genap, maka skip */
            /* step perulangan ini, lanjutkan ke i atau */
            /* bilangan selanjutnya */
            continue
        }

        println(i)
    }
}