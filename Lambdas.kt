package io.chanchan.talk_playground

fun printFormattedList(list: List<String>, format: (String) -> String) {
    for (s in list) {
        println(format(s))
    }
}

fun exampleFunc() {
    val list = listOf("hello", "world")
    fun capitalizeString(str: String) = str.toUpperCase()
    printFormattedList(list, ::capitalizeString)
    // HELLO
    // WORLD

    val formatter1 = { str: String -> str.toUpperCase() }
    printFormattedList(list, formatter1)

    val formatter2: (String) -> String = { str -> str.toUpperCase() }
    printFormattedList(list, formatter2)

    // using it
    printFormattedList(list, { it.toUpperCase() })

    // lambdas return like expressions
    val formatter3: (String) -> String = {
        if (it.length > 2) {
            it.toUpperCase()
        } else {
            it
        }
    }
    listOf("a", "aa", "aaa").map(formatter3) // ["a", "aa", "AAA"]

    // lambdas outside of parens
    val ints = listOf(-2, -1, 0, 1, 2)
    ints.filter { it > 0 } // [1, 2]

    // lambdas can access closure
    var sum = 0
    ints.filter { it > 0 }.forEach {
        sum += it
    }
}
