package github.actions.android

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TextReverserTest {

    private lateinit var textReverser: TextReverser

    @Before
    fun setUp() {
        textReverser = TextReverser()
    }

    @Test
    fun reverse() {
        val testText = "This is a test text"
        val reversedTestText = "txet tset a si sihT"
        assertEquals(textReverser.reverse(testText), reversedTestText)
    }

    @Test
    fun doubleReverse() {
        val testText = "This is a test text"
        assertEquals(textReverser.reverse(textReverser.reverse(testText)), testText)
    }
}