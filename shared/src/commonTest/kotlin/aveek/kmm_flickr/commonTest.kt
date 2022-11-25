package aveek.kmm_flickr

import aveek.kmm_flickr.api.ImageApi
import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        assertTrue(ImageApi().fetchImage().contains("Hello"), "Check 'Hello' is mentioned")
    }
}