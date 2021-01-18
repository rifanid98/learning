package kotlin03_generic.lesson01_generic

fun divider(title: String, tab: Int = 0) {
    println("\n")
    println("#############################################################")
    for (i in 0..tab) {
        print("\t")
    }
    print("$title\n")
    println("#############################################################")
}