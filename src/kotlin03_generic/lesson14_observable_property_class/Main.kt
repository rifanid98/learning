package kotlin03_generic.lesson14_observable_property_class

import kotlin03_generic.lesson01_generic.divider
import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

/**
 * ObservableProperty Class
 *
 * - Generic interface delegate yang sebelumnya kita gunakan
 *   (ReadOnlyProperty dan ReadWriteProperty) kita perlu mengatur value
 *   datanya secara manual.
 * - Kadang kita hanya butuh melakukan sesuatu sebelum dan setelah data
 *   nya diubah.
 * - Untuk kasus seperti ini, kita bisa menggunakan generic class
 *   ObservableProperty.
 */
class LogObservableProperty<T>(data: T): ObservableProperty<T>(data) {

    override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean {
        println("Before change value from $oldValue to $newValue")
        return true
    }

    override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) {
        println("After change value from $oldValue to $newValue")
    }

}

class Car(brand: String) {
    var brand: String by LogObservableProperty<String>(brand);
}

fun runObservablePropertyClass() {
    val car = Car("Toyota")
    car.brand = "Wuling"
    println(car.brand)
}

/**
 * Object Delegates
 */
/*
    -----------------------------------------------------------------
    | Function                  |   Keterangan                      |
    -----------------------------------------------------------------
    | Delegates.notNull()       | ReadWriteProperty yang nilai awal |
    |                           | bisa null, namun error jika masih |
    |                           | null                              |
    |---------------------------------------------------------------|
    | Delegates.vetoable(value, | ObservableProperty dengan         |
    | beforeChange)             | beforeChange                      |
    |---------------------------------------------------------------|
    | Delegates.observable(     | ObservableProperty dengan         |
    | value, afterChange)       | afterChange                       |
    -----------------------------------------------------------------
 */

class Car2(brand: String) {
    var brand: String by LogObservableProperty<String>(brand);
    var owner: String by Delegates.notNull<String>()
    var year: Int by Delegates.vetoable(2000) {property, oldValue, newValue ->
        println("Before change ${property.name} from $oldValue to $newValue")
        true
    }
    var description: String by Delegates.observable("") {property, oldValue, newValue ->
        println("After change ${property.name} from $oldValue to $newValue")
    }
}

fun runObjectDelegates() {
    var car = Car2("Toyota")
    car.brand = "Wuling"
    println(car.brand)

    car.owner = "Adnin" // jika dicomment, maka akan error diingatkan untuk mengisi valuenya dulu
    println(car.owner)

    car.year = 2021
    println(car.year)

    car.description = "Mobil"
    println(car.description)
}

fun main() {
    divider("Observable Property Class", 4)
    runObservablePropertyClass()

    divider("Object Delegates", 5)
    runObjectDelegates()
}