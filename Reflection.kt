package io.chanchan.talk_playground

// property references

fun propertyReferences() {
    val strs = listOf("a", "bc", "def")
    println(strs.map(String::length))
}

// class references

// getting Kotlin class / getting Java class
class TestClass

fun reflection() {
    val c = TestClass::class // KClass
    val jc = TestClass::class.java
}

// function references

fun isOdd(x: Int) = x % 2 != 0
fun isOddMain() {
    // could just call it
    isOdd(5)

    // or pass it as a value
    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd)) // [1, 3]
}

// example: function composition
fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x))}
}
fun composeExample() {
    fun length(s: String) = s.length

    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")

    println(strings.filter(oddLength)) // [a, abc]
}

