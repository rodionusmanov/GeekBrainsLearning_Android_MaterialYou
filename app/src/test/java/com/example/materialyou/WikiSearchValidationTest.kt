package com.example.materialyou

import com.example.materialyou.utils.*
import org.junit.Assert.*
import org.junit.Test

class WikiSearchValidationTest {

    @Test
    fun wikiSearchFragmentValidation_Text_ReturnsTrue() {
        assertTrue(isValidSearch("request"))
    }

    @Test
    fun wikiSearchFragmentValidation_Symbols_ReturnsTrue() {
        assertTrue(isValidSearch("@"))
    }

    @Test
    fun wikiSearchFragmentValidation_Numbers_ReturnsTrue() {
        assertTrue(isValidSearch("1984"))
    }

    @Test
    fun wikiSearchFragmentValidation_EmptyRequest_ReturnsFalse() {
        assertFalse(isValidSearch(""))
    }

    @Test
    fun wikiSearchFragmentValidation_NullRequest_ReturnsFalse() {
        assertFalse(isValidSearch(null))
    }

    @Test
    fun podFragmentNullValidator_testEquals() {
        assertEquals(nullValidator(null), null)
    }

    @Test
    fun podFragmentNullValidator_testNotEquals() {
        assertNotEquals(nullValidator("text"), null)
    }

    @Test
    fun podFragmentNullValidator_testNull() {
        assertNull(nullValidator(null))
    }

    @Test
    fun podFragmentNullValidator_testNotNull() {
        assertNotNull(nullValidator("text"))
    }

    @Test
    fun testAssertSame(){
        assertNull(descriptionBody, null)
    }

    @Test
    fun testAssertArrayEquals() {
        assertArrayEquals(
            rainbowIdColor,
            arrayOf(
                R.color.rainbowA,
                R.color.rainbowB,
                R.color.rainbowC,
                R.color.rainbowD,
                R.color.rainbowE,
                R.color.rainbowF,
                R.color.rainbowG,
                R.color.rainbowH,
                R.color.rainbowI,
                R.color.rainbowJ,
                R.color.rainbowK,
                R.color.rainbowL,
                R.color.rainbowM,
                R.color.rainbowN,
                R.color.rainbowO,
                R.color.rainbowP,
                R.color.rainbowQ,
                R.color.rainbowR,
                R.color.rainbowS,
                R.color.rainbowT,
                R.color.rainbowU,
                R.color.rainbowV,
                R.color.rainbowW,
                R.color.rainbowX,
                R.color.rainbowY,
                R.color.rainbowZ,
                R.color.rainbowAa,
                R.color.rainbowAb,
                R.color.rainbowAc,
                R.color.rainbowAd,
                R.color.rainbowAe,
                R.color.rainbowAf,
                R.color.rainbowAg,
                R.color.rainbowAh,
                R.color.rainbowAi,
                R.color.rainbowAj
            )
        )
    }
}