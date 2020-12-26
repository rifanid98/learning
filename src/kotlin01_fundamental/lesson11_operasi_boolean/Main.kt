package kotlin01_fundamental.lesson11_operasi_boolean

fun main() {
    /**
     * Operasi Boolean digunakan untuk
     * membandingkan atau menggambungkan
     * dua nilai boolean.
     *
     * Operasi Boolean dikenal juga dengan
     * operasi logika.
     *
     * Operasi boolean yang didukung di
     * kotlin:
     * &&
     * ||
     * !
     * etc..
     */
    println("----- && (AND)")
    println("true && true \t: ${true && true}")
    println("true && false \t: ${true && false}")
    println("false && true \t: ${false && true}")
    println("false && false \t: ${false && false}")

    println("----- && (OR)")
    println("true || true \t: ${true || true}")
    println("true || false \t: ${true || false}")
    println("false || true \t: ${false || true}")
    println("false || false \t: ${false || false}")

    println("----- ! (NOT)")
    println("!true \t\t: ${!true}")
    println("!false \t\t: ${!false}")

    /**
     * Case Study
     *
     * Jika nilainya lebih dari 90 dan
     * absen lebih atau sama dengan 70
     * maka siswa dianggap lulus. Jika
     * tidak memenuhi syarat tersebut,
     * maka siswa tidak lulus.
     */
    println("----- Case Study")
    val nilai = 90
    val absen = 70


    if (nilai > 80 && absen >= 75) {
        println("Anda Lulus")
    } else {
        println("Anda Tidak Lulus")
    }
}