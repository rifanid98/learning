package kotlin02_oop.lesson40_observable_properties

import kotlin.properties.Delegates

/**
 * Observable Properties
 *
 * - Salah satu standar library yang disediakan oleh Kotlin untuk
 *   delegating di properties adalah observable properties.
 * - Dengan observable properties, kita bisa tahu properties, value
 *   sebelum dan value setelah ketika diubah.
 */
class ObservableProperties(name: String) {
    var name: String by Delegates.observable(name) {
        property, oldValue, newValue ->
            println("${property.name} changed from $oldValue to $newValue")
    }
}

fun main() {
    val observableProperties: ObservableProperties = ObservableProperties("Adnin")
    observableProperties.name = "Rifandi"
    observableProperties.name = "Sutanto"
    observableProperties.name = "Putra"
}