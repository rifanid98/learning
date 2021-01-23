package kotlin04_collection.lesson30_ordering_custom

/**
 * Ordering: Custom
 *
 * - Selain menggunakan comparable bawaan kotlin, kita juga bisa membuat
 *   comparable sendiri.
 * - Ini cocok untuk mengurutkan data yang kita buat sendiri.
 */
/*
    Ordering Operators
    -------------------------------------------------------------------------------
    |    Ordering Operators                 |              Keterangan             |
    -------------------------------------------------------------------------------
    | sortedBy(selector: (T) -> R)          | Mengurutkan collection secara       |
    |                                       | ascending menggunakan selector      |
    |-----------------------------------------------------------------------------|
    | sortedByDescending(selector: (T) -> R)| Mengurutkan collection secara       |
    |                                       | descending menggunakan selector     |
    |-----------------------------------------------------------------------------|
    | sortedWith(Comparator<T>)             | Mengurutkan collection dengan       |
    |                                       | Comparator<T>                       |
    -------------------------------------------------------------------------------
*/
data class Fruit(val name: String, val quantity: Int)

fun main() {
    val fruits: List<Fruit> = listOf(
        Fruit("Apple", 10),
        Fruit("Orange", 5)
    )
    println(fruits.sortedBy { fruit -> fruit.quantity })
    println(fruits.sortedByDescending { fruit -> fruit.quantity })
    println(fruits.sortedWith(compareBy { fruit -> fruit.quantity }))
    println(fruits.sortedWith(compareByDescending { fruit -> fruit.quantity }))
    println(fruits.sortedWith(Comparator { fruit1, fruit2 ->
        fruit1.quantity.compareTo(fruit2.quantity)
    }))
}