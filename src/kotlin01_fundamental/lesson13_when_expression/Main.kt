package kotlin01_fundamental.lesson13_when_expression

fun main() {
    val nilai: Int = 90
    var lulus: Boolean? = null

    /* When Single Option */
    println("----- When Single Option")
    when (nilai) {
        100 -> {
            println("A+")
            // more line
        }
        90 -> {
            println("A")
            lulus = true
        }
        80 -> println("B")
        75 -> println("C")
        60 -> println("D")
        45 -> println("E")
        else -> println("Z")
    }

    println(lulus)

    /* When Multiple Option */
    println("----- When Multiple Option")
    when (nilai) {
        100, 90, 80, 75 -> println("Lulus")
        else -> println("Tidak Lulus")
    }

    /* When Expression In */
    println("----- When Expression In")

    val kkm: Array<Int> = arrayOf(10, 90, 80, 75)
    when(nilai) {
        in kkm -> println("Lulus")
        !in kkm -> println("Tidak Lulus")
    }

    /* When Expression Is */
    println("----- When Expression Is")

    val name: String = "Adnin"
    when(name) {
        is String -> println("tipe datanya String")
        !is String -> println("bukan String")
    }
}