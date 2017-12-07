package io.chanchan.talk_playground

//// Extension Functions

// prefix function name w/ a receiver type (the type being extended)

// 3.isOdd() // true
fun Int.isOdd() = this % 2 != 0
// 2.isEven() // true
fun Int.isEven() = this % 2 == 0

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}
val l = mutableListOf(1, 2, 3)
//l.swap(0, 2) // [3, 2, 1]

fun <T> T.basicToString() : String {
    return this.toString()
}
// 1.basicToString()
// "hello".basicToString()

//// Extension Properties

val <T> List<T>.lastIndex: Int
    get() = size - 1
fun test() {
    val list = listOf("a", "b", "c")
    println(list.lastIndex) // 2
}