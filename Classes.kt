package io.chanchan.talk_playground

class Person
val person = Person()

// can omit constructor keyword
class Train(number: Int)

// init block
class Bird(breed: String) {
    init {
        println("Bird initialized with breed $breed")
    }
}

// property
class Dog(breed: String) {
    val identifier = breed
}
val dog = Dog("Husky")
//println(dog.breed) // Husky

// constructor property shorthand
class Cat(val breed: String)
val cat = Cat("Norwegian Forest Cat")
//println(cat.breed) // Norwegian Forest Cat

// default property values + property visibility
class Presentation (
    val name: String = "Learn Kotlin for Love and Sanity",
    private val presenter: String = "Mark Chandler"
)
val presentation = Presentation(presenter = "Brandon Wever")
//println(presentation.name) // Learn Kotlin for Love and Sanity

// custom getters/setters
class Container(private var numItems: Int) {
    val isEmpty: Boolean
        get() = numItems == 0

    var count: Int
        get() = numItems
        set(value) {
            println("Updating count to $value")
            numItems = value
        }
}

// lateinit properties
class Vape {
    lateinit var brand: String

    fun changeBrand(name: String) {
        this.brand = brand
    }
}
val vape = Vape()
//vape.changeBrand("SMOK")
//println(vape.brand) // SMOK

//@RunWith(MockitoJUnitRunner::class)
//class ClassTest {
//    private lateinit var xmlToJsonParser: XmlToJsonParser
//
//    @Test
//    fun whatever() {
//        xmlToJsonParser.parse(...)
//    }
//}

// defining methods on a class
class Business(val name: String) {
    fun capitalizeName(): String = name.capitalize()
}
val business = Business("kroger")
//println(business.capitalizeName()) // Kroger

// inheritance
class Example // implicitly inherits from Any

open class Base(p: Int)
class Derived(p: Int) : Base(p)

// overriding methods
open class First {
    open fun v() {}
    fun nv() {}
}
class Second() : First() {
    override fun v() {}
}

// overriding properties
open class Foo {
    open val x: Int get() { return 0 }
}
class Bar1 : Foo() {
    override val x: Int = 5
}

//// Data Classes
// things we get out of the box:
//  equals()/hashCode()
//  toString()
//  componentN() functions for properties
//  copy()

data class Friend(val firstName: String, val lastName: String)
fun friendFunc() {
    val person1 = Friend("Ryan", "Brown")
    val person2 = Friend("Brandon", "Wever")
    val person3 = Friend("Brandon", "Wever")

    println(person1) // Friend(firstName=Ryan, lastName=Brown)

    println("${person2.firstName} ${person2.lastName}") // Brandon Wever
    println("${person2.component1()} ${person2.component2()}") // Brandon Wever

    val (firstName, lastName) = person2
    println("$firstName $lastName") // Brandon Wever

    person1.equals(person2) // false
    person1 == person2 // false
    person2.equals(person3) // true
    person3 == person3

    val person4 = person1.copy(lastName = "White", firstName = "John")
    println(person4) // Friend(firstName=John, lastName=White)
}

//// Enum Classes
enum class Direction {
    NORTH, SOUTH, EAST, WEST
}
val currentDirection = Direction.NORTH

// enum classes can be initialized
enum class Shape(val adjective: String?) {
    CIRCLE("round"),
    SQUARE("boxy"),
    RHOMBUS("oblongish")
}
val shape = Shape.CIRCLE
//println(shape) // CIRCLE
//println(shape.adjective) // round

// enum constants can be used as anonymous classes
enum class ProtocolState{
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}
val state = ProtocolState.WAITING
//println(state.signal()) // TALKING

//// Sealed Classes
sealed class Expr // cannot be instantiated, only subclassed
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

fun eval(expr: Expr): Double = when(expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
    // else not required because we've covered all cases
}
