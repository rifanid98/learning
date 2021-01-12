package kotlin02_oop.lesson21_abstract_class

/**
 * Abstract Class
 *
 * - Saat kita membuat class, kita bisa menjadikan sebuah class
 *   sebagai abstract.
 * - Abstract class artinya, class tersebut tidak bisa dibuat sebagai
 *   object, hanya bisa diturunkan.
 */
abstract class Location(val name: String)

class City(name: String): Location(name)

fun main() {
    //val location: Location = Location("West Java") // ERROR.Abstract class
    val city: City = City("Bogor")
    println(city.name)
}