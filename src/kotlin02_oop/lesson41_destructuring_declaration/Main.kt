package kotlin02_oop.lesson41_destructuring_declaration

import kotlin02_oop.lesson17_type_check_casts.divider

//#################################################################
//               DESTRUCTURING DECLARATIONS CLASS
//#################################################################

/**
 * Destructuring Declaration
 *
 * - Destructuring declaration adalah membuat multiple variables dari
 *   sebuah object.
 * - Destructuring tidak bisa dilakukan untuk semua object,  hanya
 *   objek yang memiliki function componentX() yang bisa dilakukan
 *   destructuring.
 * - Saat kita membuat data class, secara otomatis akan dibuatkan
 *   function componentX() sesuai dengan jumlah parameter nya.
 */
/* Manual */
class Komputer(val name: String, val price: Int) {
    operator fun component1(): String = name
    operator fun component2(): Int = price
}
/* Otomatis oleh kotlin */
data class Game(val name: String, val price: Int)

fun runDestructuringDeclarationsClass() {
    println("----- Manual")
    val komputer: Komputer = Komputer("Acer Predator", 1_000_000)
    val nameKom = komputer.component1()
    val priceKom = komputer.component2()
    println(nameKom)
    println(priceKom)

    println("----- Auto")
    val game: Game = Game("Zelda", 500_000)
    val (name: String, price: Int) = game
    println(name)
    println(price)
}

//#################################################################
//              DESTRUCTURING DECLARATIONS FUNCTION
//#################################################################

/**
 * Destructuring Declarations di Function
 *
 * - Destructuring declarations juga bisa dilakukan ketika memanggil
 *   function.
 * - Dengan ini, seakan-akan kita bisa mengembalikan multiple return
 *   value pada function.
 */
data class MinMax(val min: Int, val max: Int)

fun minmax(val1: Int, val2: Int): MinMax {
    return when {
        val1 > val2 -> MinMax(val2, val1)
        else -> MinMax(val1, val2)
    }
}

fun runDestructuringDeclarationsFunction() {
    val (min, max) = minmax(1_000, 100)
    println(min)
    println(max)
}

//#################################################################
//          DESTRUCTURING DECLARATIONS FUNCTION MIN ONLY
//#################################################################

/**
 * Underscore
 *
 * - Kadang kita hanya ingin melakukan destructuring pada beberapa
 *   variable, dan menghiraukan variable lainnya.
 * - Untuk menghiraukan suatu variable, kita bisa menggunakan kata
 *   kunci  _ (underscore).
 */
fun runDestructuringDeclarationsFunctionMinOnly() {
    val (min, _) = minmax(1_000, 100)
    println(min)
}

//#################################################################
//          DESTRUCTURING DECLARATIONS LAMBDA PARAMETER
//#################################################################

/**
 * Destructuring Lambda Parameter
 *
 * - Destructuring juga bisa dilakukan di lambda parameter.
 * - Hal ini bisa mempermudah kita saat ingin mengakses data yang ada
 *   di parameter.
 */
data class Login(val user: String, val pass: String)
typealias  LoginCallback = (Login) -> Boolean

fun login(login: Login, callback: LoginCallback): Boolean {
    return callback(login)
}

fun runDestructuringDeclarationsFunctionLambdaParameter() {
    val request: Login = Login("root", "root")
    val login: Boolean = login(request) {(user, pass) ->
        user == "root" && pass == "root"
    }

    if (!login) {
        println("Login Gagal!")
    } else {
        println("Login Sukses!")
    }
}

fun main() {
    divider("Destructuring Declarations Class", 2)
    runDestructuringDeclarationsClass()

    divider("Destructuring Declarations Function", 2)
    runDestructuringDeclarationsFunction()

    divider("Destructuring Declarations Function Min Only", 1)
    runDestructuringDeclarationsFunctionMinOnly()

    divider("Destructuring Declarations Lambda Parameter", 1)
    runDestructuringDeclarationsFunctionLambdaParameter()
}