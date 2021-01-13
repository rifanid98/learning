package kotlin02_oop.lesson26_visibility_modifiers

/**
 * Visibility Modifiers
 *
 * - Class, Interface, Constructor, Function, dan Properties (termasuk
 *   Getter dan Setter) bisa memiliki Visibility Modifiers di Kotlin.
 * - Ada 4 visibility modifiers di kotlin, yaitu: public, private,
 *   protected, internal.
 * - Secara standar visibility modifiers di kotlin adalah public.
 */
/*
    Perbedaan tiap Visibility Modifiers

    --------------------------------------------------------------------
    | Modifiers | Keterangan                                           |
    --------------------------------------------------------------------
    | public    | Jika tidak menyebutkan, maka secara otomatis visibi- |
    |           | tinya adalah public, yang artinya bisa diakses dari  |
    |           | manapun.                                             |
    |------------------------------------------------------------------|
    | private   | Artinya hanya bisa diakses di tempat deklarasinya    |
    |------------------------------------------------------------------|
    | protected | Artinya hanya bisa diakses di tempat deklarasi, dan  |
    |           | juga turunannya                                      |
    |------------------------------------------------------------------|
    | internal  | Artinya hanya bisa diakses di module/project yang    |
    |           | sama                                                 |
    --------------------------------------------------------------------
 */
open class Teacher(var name: String) {
    /* Bisa diakses di dalam project dan di luar project */
    public fun teach1() {
        println("Teach")
    }

    /* Bisa diakses di dalam project saja */
    internal fun teach2() {
        println("Teach")
    }

    /* Bisa diakses di dalam parent class dan child classnya */
    protected fun teach3() {
        println("Teach")
    }

    /* Bisa diakses di dalam class ini saja */
    private fun teach4() {
        println("Teach")
    }

    private fun teach() {
        // can use all method
        this.teach1()
        this.teach2()
        this.teach3()
        this.teach4()
    }
}

class MathTeacher(name: String): Teacher(name) {

    private fun getTeach3() {
        // can use teach1~teach3, not teach4
        super.teach1()
        super.teach2()
        super.teach3()
    }

}

fun main() {
    val teacher: Teacher = Teacher("Adnin")
    println(teacher.name)
    //teacher.teach() // ERROR. teach() is private
    // can use teach1 & teach2 only, not teach3 & teach4
    teacher.teach1()
    teacher.teach2()
}