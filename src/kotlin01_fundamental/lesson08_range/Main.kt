package kotlin01_fundamental.lesson08_range

fun main() {
    /**
     * Range
     */
    /* Deklarasi Range */
    val numbers1: IntRange = 1..100
    val numbers2: IntRange =  1.rangeTo(100)
    val numbers3: IntProgression = 100 downTo 0
    val numbers4: IntProgression = 100..0 step 5       // 100 ke 0 dengan kelipatannya 5
    val numbers5: IntProgression = 100 downTo 0 step 5 // 100 ke 0 dengan kelipatannya 5

    /* Method yang ada di Range */
    println("count \t\t: ${numbers1.count()}")
    println("contains \t: ${numbers1.contains(50)}")
    println("first \t\t: ${numbers1.first}")
    println("last \t\t: ${numbers1.last}")
    println("step \t\t: ${numbers1.step}")
}