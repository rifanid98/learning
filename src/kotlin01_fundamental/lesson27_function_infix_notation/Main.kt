package kotlin01_fundamental.lesson27_function_infix_notation

fun main() {
    val name: String = "Adnin"
    val nameUp: String = name to "up"
    val nameLo: String = name to "lo"

    println(name)
    println(nameUp)
    println(nameLo)
}

/**
 * Infix Notation
 *
 * - Infix Notation adalah operasi yang biasa dilakukan di operasi matematika,
 *  di mana dia melakukan operasi terhadap dua data
 * - Hampir semua operasi matematika adalah infix notation
 */
infix fun String.to(type: String): String {
    when (type.toLowerCase()) {
        "up" -> return this.toUpperCase()
        "lo" -> return this.toLowerCase()
        else -> return type
    }
}