package io.chanchan.talk_playground

fun main(args: Array<String>) {
    var a: String = "abc"
//    a = null

    var b: String? = "abc"
    b = null

    val str: String? = "hello"

    // Safe Call Operator
    println(str?.length)

    // Explicit Null Check
    if (str != null) {
        println(str.length)
    }

    // Safe Call w/ Let
    val listWithNulls: List<String?> = listOf("A", null)
    for (item in listWithNulls) {
        item?.let {
            println(it)
        }
    }

    // Elvis Operator
    val fubar: String? = "fubar"
    val length = fubar?.length ?: -1

    // Not Null Assertion
    val l = str!!.length
}

class Node(val parent: Node?, val name: String?)
fun elvisControlFlow(node: Node): String? {
    val parent = node.parent ?: return null
    val name = node.name ?: throw IllegalArgumentException("name expected")
    return "$parent: $name"
}