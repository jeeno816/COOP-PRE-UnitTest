package chapter4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class `Example 4-4` {

    @Test
    fun messageRenderer_uses_correct_sub_renderers(){
        val sut = MessageRenderer()
        val message = Message().apply{
            header = "h"
            body = "b"
            footer = "f"
        }

        val html = sut.render(message)
        assertEquals("<h1>h</h1><b>b</b><i>f</i>",html)

    }
}