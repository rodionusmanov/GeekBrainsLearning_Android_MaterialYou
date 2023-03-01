package com.example.materialyou

import com.example.materialyou.utils.isValidSearch
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
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
}