package io.chanchan.talk_playground

// Unit can be omitted
fun basicFunction() {
    println("Hey")
}

// return type
fun anotherFunction(): String {
    return "Hey"
}

// single-expression function
fun echoString(str: String) = str

// default args/named args
fun yetAnotherFunction(name: String = "Mark", description: String = "Description") {
    println("$name: $description")
}
//yetAnotherFunction(description = "A dude with a beard", name = "Mark")

// generic functions
fun <T> singletonList(item: T): List<T> {
    return listOf(item)
}
