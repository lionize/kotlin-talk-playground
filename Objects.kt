package io.chanchan.talk_playground

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

val adHoc = object {
    var x: Int = 0
    var y: Int = 0
}

// object expressions – anonymous class that inherits from some type
fun countClicks(window: JComponent) {
    var clickCount = 0
    var enterCount = 0

    window.addMouseListener(object: MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent?) {
            enterCount++
        }
    })
}

object DataProviderManager {
    val providers = mutableListOf<String>()

    fun registerDataProvider(provider: String) {
        providers.add(provider)
    }
}
fun dataProvider() {
    DataProviderManager.registerDataProvider("SQL")
    DataProviderManager.registerDataProvider("mongo")

    println(DataProviderManager.providers) // [SQL, mongo]
}

// Companion Object
class MyClass {
    companion object {
        fun build(): MyClass = MyClass()
    }
}
val instance = MyClass.build()
