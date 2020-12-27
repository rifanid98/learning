package kotlin01_fundamental.lesson37_label

/**
 * Label
 *
 * - Label adalah penanda.
 * - Semua expression di Kotlin bisa ditandai dengan label.
 * - Label bisa diintegrasikan dengan break,continue dan return.
 * - Biasanya break, continue dan return hanya bisa menghentikan proses
 *   di blok kode tempat mereka berada, namun dengan menggunakan label,
 *   kita bisa menentukan ke label mana kode akan berhenti.
 */
fun main() {
    /* Label */
    println("----- Label")
    loopI1@ for (i: Int in 1..5) {
        loopJ1@ for (j: Int in 1..5) {
            println("$i x $j = ${i * j}")
        }
    }

    /* Break to Label */
    println("----- Break to Label")
    loopI2@ for (i: Int in 1..5  ) {
        loopJ2@ for (j: Int in 1..5) {
            if (i > 3) {
                println("break")
                break@loopI2
            }
            println("$i x $j = ${i * j}")
        }
    }

    /* Continue to Label */
    println("----- Continue to Label")
    loopI3@ for (i: Int in 1..5) {
        loopJ3@ for (j: Int in 1..5) {
            if (j > 3) {
                println("continue")
                continue@loopI3
            }
            println("$i x $j = ${i * j}")
        }
    }

    /* Return to Label */
    fun test(name: String, param: (String) -> Unit): Unit = param(name)
    test("Adnin") testLabel@ {
        if (it.isBlank()) {
            return@testLabel
        } else {
            println("$it")
        }
    }
}