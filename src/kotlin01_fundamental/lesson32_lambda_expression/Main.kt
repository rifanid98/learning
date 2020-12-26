package kotlin01_fundamental.lesson32_lambda_expression

fun main() {
    /**
     * val varName: lambda = value
     *
     * lambda = lambda as data type
     * value = the lambda itself
     */
    /* single parameter */
    println("----- single parameter")
    // cara 1
    val lambdaSingle1: (String) -> String = { "Hello $it" }
    println(lambdaSingle1("Adnin Rifandi"))
    val lambdaSingle2: (String) -> String = { name: String -> name }
    println(lambdaSingle2("Sutanto Putra"))

    /* multiple parameter */
    println("----- multiple parameter")
    val lambdaMulti: (String, String) -> String = {
        firstName: String, lastName: String ->
            val result = "$firstName $lastName"
            result
    }

    val fullName = lambdaMulti("Adnin", "Rifandi")
    println(fullName)

    /* Method Reference */
    // dari ini
    val lambdaMethodReference1: (String) -> String = { name -> name.toUpperCase() }
    println(lambdaMethodReference1("Adnin Rifandi"))
    // menjadi seperti ini
    fun toUpper(name: String): String = name.toUpperCase()
    val lambdaMethodReference2: (String) -> String = ::toUpper
    println(lambdaMethodReference2("Adnin Rifandi"))
}