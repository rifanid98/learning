package kotlin02_oop.lesson12_function_overriding

/**
 * Function Overriding
 *
 * - Function Overriding adalah kemampuan membuat ulang function yang sudah ada di class Parent.
 * - Secara standar, function di class adalah final, tidak bisa dibuat ulang di class Child.
 * - Agar function bisa dibuat ulang di class Child, kita harus menggunakan kata kunci open.
 */
/* Parent Class */
open class Person(val name: String) {

    open fun sayHello(yourName: String): Unit {
        println("Hello $yourName, my name is ${this.name}")
    }

}

/* Child Class */
open class Teacher(
    name: String,
    val school: String
): Person(name) {

    final override fun sayHello(yourName: String) {
        super.sayHello(yourName)
    }

    fun teach() {
        println("${this.name} is teaching")
    }
}

/* Child Class of Class Teacher */
class MathTeacher(
    name: String,
    school: String
): Teacher(name, school) {

    //error tidak bisa overrid, karena sudah final
    //override sayHello()
}

/* Child Class */
class Student(
    name: String,
    val school: String
): Person(name) {

    /**
     * Final Override Function
     *
     * - Saat kita membuat ulang function di class Child, secara standar, function tersebut
     *   bersifat open, yang artinya bisa dibuat ulang di class Child dibawahnya lagi.
     * - Jika ingin membuat override function tidak bisa dibuat ulang oleh class Child dibawahnya
     *   lagi, kita harus menggunakan kata kunci final.
     */
    final override fun sayHello(yourName: String) {
        println("Hello $yourName, i'am a student")
    }

    fun study() {
        println("${this.name} is studying")
    }
}


fun main() {
    println("----- #Teacher")
    val teacher: Teacher = Teacher("Adnin Rifandi", "SMK N 1 Ciomas")
    teacher.sayHello("Sutanto Putra")
    teacher.teach()

    println("----- #Student")
    val student: Student = Student("Adnin", "SMK N 1 Ciomas")
    student.sayHello("Eko") // function overriding
    student.study()
}