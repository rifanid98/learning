package kotlin01_fundamental.lesson05_string

fun main() {
    /**
     * String
     */
    var firstName = "Adnin"
    var lastName = "Rifandi"
    var address = """
        |Kp. Sinagar, RT. 03/07,
        |Ds. Cihideung Udik, Kec. 
        |Ciampea, Kab. Bogor 16620
    """.trimMargin()

    println(firstName)
    println(lastName)
    println(address)

    /* Concatenation */
    // cara 1
    println(firstName + " " + lastName)
    // cara 2 (concatenation template)
    println("$firstName $lastName")
    println("panjang karakter = ${firstName.length + lastName.length}")
}