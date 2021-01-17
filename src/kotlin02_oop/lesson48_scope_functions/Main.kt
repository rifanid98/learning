package kotlin02_oop.lesson48_scope_functions

import kotlin02_oop.lesson17_type_check_casts.divider

/**
 * Scope Functions
 *
 * - Kotlin memiliki standar library yang berisikan beberapa function
 *   yang bisa digunakan untuk mengeksekusi object dengan mudah
 *   memanfaatkan lambda expression.
 * - Function-function tersebut adalah let, run, with, apply, dan also.
 */
class Student(
    var name: String,
    val age: Int
)

/*
    ------------------------------------------------------------------------------------------
    | Function  | Object    | Return Value   | Is Extension Function                         |
    |           | Reference |                |                                               |
    ------------------------------------------------------------------------------------------
    | let       | it        | Lambda Result  | Yes                                           |
    | run       | this      | Lambda Result  | Yes                                           |
    | run       | -         | Lambda Result  | No: called without the context object         |
    | with      | this      | Lambda Result  | No: takes the context object as an argument   |
    | apply     | this      | Context Object | Yes                                           |
    | also      | this      | Context Object | Yes                                           |
    ------------------------------------------------------------------------------------------
 */

/**
 * Let Function
 *
 * - Let function bisa digunakan sebagai reference block agar kita bisa
 *   lebih mudah ketika ingin memanipulasi sebuah object.
 * - Let function memiliki parameter object itu sendiri, sehingga kita
 *   bisa menggunakan kata kunci it untuk mendapatkan referensi terhadap
 *   object tersebut.
 */
fun runLet() {
    val student: Student = Student("Budi", 22)
    // cara 1
    println("----- Cara 1")
    student.let {
        println(it.name)
        println(it.age)
    }
    // cara 2
    println("----- Cara 2")
    val result1: String = student.let {
        println(it.name)
        println(it.age)
        "Ini Let"
    }
    println(result1)
    // cara 3
    println("----- Cara 3 ")
    val result2: String = student.let {
        "Name ${it.name}, Age ${it.age}"
    }
    println(result2)
}

/**
 * Run Function
 *
 * - Run function mirip dengan let function.
 * - Yang membedakan adalah, pada run function, tidak ada parameter
 *   pada lambda nya, sehingga kita tidak bisa mengakses reference
 *   object menggunakan kata kunci it. Namun kita masih bisa menggunakan
 *   kata kunci this.
 */
fun runRun() {
    val student: Student = Student("Budi", 22)
    // cara 1
    println("----- Cara 1")
    student.run {
        println(this.name)
        println(this.age)
    }
    // cara 2
    println("----- Cara 2")
    val result1: String = student.run {
        println(this.name)
        println(this.age)
        "Ini Let"
    }
    println(result1)
    // cara 3
    println("----- Cara 3 ")
    val result2: String = student.run {
        "Name ${this.name}, Age ${this.age}"
    }
    println(result2)
}

/**
 * Apply Function
 *
 * - Apply function hampir sama dengan run function.
 * - Yang membedakan adalah return value dari apply function ada
 *   reference object itu sendiri.
 */
fun runApply() {
    val student: Student = Student("Budi", 22)
    println(student.name)
    val result: Student = student.apply {
        println(this.name)
        println(this.age)
        this.name = "Adnin"
    }
    println(result.name)
}

/**
 * Also Function
 *
 * - Also function mirip dengan let function.
 * - Yang membedakan adalah, pada also function, return value nya
 *   adalah reference ke object itu sendiri.
 */
fun runAlso() {
    val student: Student = Student("Budi", 22)
    println(student.name)
    val result: Student = student.also {
        println(it.name)
        println(it.age)
        it.name = "Adnin"
    }
    println(result.name)
}

/**
 * With Function
 *
 * - With function mirip dengan run function, menggunakan reference
 *   this.
 * - Yang membedakan adalah, with function bukanlah extension function,
 *   jadi tidak bisa digunakan langsung dari object-nya.
 * - Kita harus memanggil with function secara manual.
 */
fun runWith() {
    val student: Student = Student("Budi", 22)
    // cara 1
    println("----- Cara 1")
    with(student) {
        println(this.name)
        println(this.age)
    }
    // cara 2
    println("----- Cara 2")
    val result1: String = with(student) {
        println(this.name)
        println(this.age)
        "Ini Let"
    }
    println(result1)
    // cara 3
    println("----- Cara 3 ")
    val result2: String = with(student) {
        "Name ${this.name}, Age ${this.age}"
    }
    println(result2)
}

fun main() {
    divider("LET FUNCTION", 5)
    runLet()

    divider("RUN FUNCTION", 5)
    runRun()

    divider("APPLY FUNCTION", 5)
    runApply()

    divider("ALSO FUNCTION", 5)
    runAlso()

    divider("WITH FUNCTION", 5)
    runWith()
}