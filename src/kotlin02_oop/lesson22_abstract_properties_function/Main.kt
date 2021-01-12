package kotlin02_oop.lesson22_abstract_properties_function

/**
 * Abstract Properties & Function
 *
 * - Saat kita membuat class yang abstract, kita bisa membuat
 *   properties abstract dan function abstract di dalam class tersebut.
 * - Properties dan function yang bersifat abstract, artinya wajib
 *   dibuat ulang di class Child nya.
 */
abstract class Animal {
    /**
     * Properties dan Method ini wajib dibuat ulang lagi
     * di child classnya.
     */
    abstract val name: String
    abstract fun run(): Unit
}

class Cat: Animal() {
    /**
     * Implement nya harus menggunakan keyword override
     * karena memang membuat ulang aka overrid property
     * dan method yang ada di parent class nya.
     */
    override val name: String = "Cat"
    override fun run(): Unit {
        println("${this.name} is running")
    }
}

fun main() {
    val cat: Cat = Cat()
    println(cat.name)
    cat.run()
}