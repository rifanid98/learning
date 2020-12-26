package kotlin01_fundamental.lesson12_if_expression

fun main() {
    val nilai = 90
    val absen = 70

    if (nilai >= 90 && absen >= 75) {
        println("Anda Lulus")
    } else if (nilai >= 90 && absen < 75) {
        println("Anda Lulus Bersyarat")
    } else {
        println("Anda Tidak Lulus")
    }
}