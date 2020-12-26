package kotlin01_fundamental.lesson16_do_while_loop

fun main() {
    /**
     * Do While Loop akan melakukan eksekusi kode
     * terlebih dahulu minimal satu kali, baru
     * memeriksa argumennya apakah false (harus
     * berhenti) atau true (harus berlanjut)
     */
    var i: Int = 0
    do {
        /* baris kode ini akan selalu dieksekusi minimal 1x */
        println(i)
        i++
    } while (i < 10)
}