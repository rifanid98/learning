package kotlin04_collection.lesson38_map_specific_operation

/**
 * Map Specific Operations
 *
 * - Di kotlin juga terdapat banyak operasi yang khusus untuk Map.
 */
/*
    Set Specific Operators 1
    -------------------------------------------------------------------------------
    |     Set Specific Operators       |                  Keterangan              |
    -------------------------------------------------------------------------------
    | getOrElse(key, (key) -> V)       | Mengambil value sesuai key, jika tidak   |
    |                                  | ada eksekusi lambda                      |
    |-----------------------------------------------------------------------------|
    | getValue(key)                    | Mengambil value sesuai key, atau throw   |
    |                                  | exception                                |
    |-----------------------------------------------------------------------------|
    | filter((Entry<K, V>) -> Boolean) | Filter sesuai kondisi                    |
    |-----------------------------------------------------------------------------|
    | filterKeys((K) -> Boolean)       | Filter sesuai kondisi key                |
    |-----------------------------------------------------------------------------|
    | filterValues((V) -> Boolean)     | Filter dengan kondisi value              |
    -------------------------------------------------------------------------------
*/
fun main() {
    val map: Map<String, Any> = mapOf(
        "name" to "Adnin",
        "age" to 22,
        "married" to true
    )

    println("map.getValue\t: ${map.getValue("name")}")
    println("map.getOrElse\t: ${map.getOrElse("address") {"Ups"}}")
    println("map.filter\t\t: ${map.filter { (key, value) -> value.toString().length > 4 }}")
    println("map.filterKeys\t: ${map.filterKeys { key -> key > "age" }}")
    println("map.filterValues: ${map.filterValues { value -> value.toString().length > 4 }}")
}