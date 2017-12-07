enum class Shape(val adjective: String?) {
    CIRCLE("round"),
    SQUARE("boxy"),
    RHOMBUS("oblongish")
}

fun main(args: Array<String>) {
    for (i in Shape.values()) {
        println(i)
    }
}