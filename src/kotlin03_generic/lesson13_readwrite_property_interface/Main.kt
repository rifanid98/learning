package kotlin03_generic.lesson13_readwrite_property_interface

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * ReadWriteProperty Interface
 *
 * - Selain ReadOnlyProperty, kita juga menggunakan interface generic
 *   ReadWriteProperty sebagai delegate.
 * - ReadWriteProperty bisa digunakan untuk variable var (mutable).
 */
class StringLogReadWriteProperty(var data: String): ReadWriteProperty<Any, String> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("You get data ${property.name} is $data")
        return data
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("You set data ${property.name} from $data to $value")
        data = value
    }

}

class Person(param: String) {
    /**
     * Pada line 13 : ReadWriteProperty<Any, String>
     *
     * - Tipe data Any itu merefer kepada class di mana dia digunakan, yang
     *   pada kasus ini adalah class Person() ini
     * - Tipe data String itu merefer kepada tipe data dari property class
     *   ini dan tipe data parameter yang digunakan/dimasukkan di function
     *   StringLogReadWriteProperty(param)
     */
    var name: String by StringLogReadWriteProperty(param)
}

fun main() {
    val person = Person("Adnin")
    person.name = "Budi"
    println(person.name)
}