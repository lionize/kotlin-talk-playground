package io.chanchan.talk_playground

interface ThingBuilder {
    val name: String
    fun build()
}

class Thing(override val name: String): ThingBuilder {
    override fun build() {
        println("Hello, $name")
    }
}

// overriding multiple interfaces
interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() { print("bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super.bar()
    }
}