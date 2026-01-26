package chapter4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class `Example 4-2` {

    @Test
    fun messageRenderer_uses_correct_sub_renderers(){
        val sut = MessageRenderer()

        val renderers = sut.subRenderers

        assertEquals(3,renderers.size)
        assertTrue(renderers[0] is HeaderRenderer)
        assertTrue(renderers[1] is BodyRenderer)
        assertTrue(renderers[2] is FooterRenderer)
    }
}