package io.chanchan.talk_playground

fun main(args: Array<String>) {
    //// Variables

    // var is reassignable
    var a = 10
    a = 5

    // val is not reassignable
    val x = 10
//    x = 11

    // val is not immutable
    val mutableList = mutableListOf("Hello", "World")
    mutableList.add("Fubar")
    println(mutableList) // [Hello, World, Fubar]

    // no "new" keyword
    class Test
    val instance = Test()

    val list: List<String>
    list = listOf("Hello", "World")

    val str: String? = null

    //// Strings

    // string templates
    val name = "Mark"
    println("My name is $name") // My name is Mark
    println("My name is ${name.length} characters") // My name is 4 characters

    // raw strings
    val rawString = """
    Kotlin is awesome
    Kotlin is great
    """

    //// Ranges

    for (i in 1..4) print(i) // 1234
    for (i in 4 downTo 1) print(i) // 4321
    for (i in 1..4 step 2) print(i) // 13
    for (i in 4 downTo 1 step 2) print(i) // 42
    // [1, 10)
    for (i in 1 until 10) {
        print(i) // 123456789
    }

    //// Collections

    // list
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    val readOnlyNumbers: List<Int> = listOf(1, 2, 3)
    numbers.add(5)
//    readOnlyNumbers.add(5)

    // inferred type
    val numbersList = listOf(1, 2, 3)

    // set
    val strings = hashSetOf("a", "b", "c", "c", "c")
    assert(strings.size == 3)

    // useful methods
    val items = listOf(1, 2, 3, 4)
    items.first() == 1
    items.last() == 4
    items.firstOrNull()

    items.forEach { println(it) }
    items.filter { it % 2 == 0 } // [2, 4]
    items.map { it * 2 } // [2, 4, 6, 8]
    if (items.none { it > 6 }) println("No items above 6")

    // map
    val map = hashMapOf(
            "foo" to 1,
            "bar" to 2
    )
    println(map["foo"]) // 1
    println(map["bar"]) // 2

    //// Control Flow

    // if
    val c = true

    if (c) {
        println("Truth!")
    } else {
        println("Objection!")
    }

    // if as an expression
    println(if (c) "Truth!" else "Objection!")
    val outcome = if (c) "Yes" else "No"

    // when
    val num = 5
    when (num) {
        1 -> println("x is 1")
        2 -> println("x is 2")
//        else -> println("x is not 1; x is not 2")
    }

    when (num) {
        1, 2 -> println("x == 1 || x == 2")
        else -> println("nope")
    }

    // 'in' to test range
    when (num) {
        in 1..10 -> println("x is between 1 and 10")
        else -> println("not in range")
    }

    // 'in' to test collection
    val validNumbers = listOf(1, 2, 3)
    val testNumber = 2
    when (testNumber) {
        in validNumbers -> println("$testNumber is valid")
        else -> println("$x is not in list of valid numbers ($validNumbers)")
    }

    // smart casting
    fun hasPrefix(x: Any) = when (x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    // when as conditional statement
    val conditionalVal = 5
    when {
        x.isOdd() -> println("x is odd")
        x.isEven() -> println("x is even")
        else -> println("x is funny")
    }

    // for loop
    val collection = listOf("a", "b", "c")

    for (item in collection) println(item)

    for (i in collection.indices) println(collection[i])

    for ((i, item) in collection.withIndex()) println("$i: $item")

    // while loop
    var whileNum = 5
    while (whileNum > 0) {
        whileNum--
    }

    do {
        val y = fakeMethod()
    } while (y != null) // y is visible here
}





fun fakeMethod() = null

