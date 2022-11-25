package aveek.kmm_flickr

import aveek.kmm_flickr.api.ImageApi
import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() {
        assertTrue(ImageApi().fetchImage().contains("iOS"), "Check iOS is mentioned")
    }
}