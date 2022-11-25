object Testing {

    private val junit = "4.13.2"
    private val mockito_core = "4.5.1"
    private val mockito_inline = "2.13.0"
    private val core_testing_version = "2.1.0"
    private val coroutine_testing_version = "1.6.1"

    val testlib_mockito = "org.mockito:mockito-core:${mockito_core}"
    val core_testing = "androidx.arch.core:core-testing:${core_testing_version}"
    val mockito_android_testing = "org.mockito:mockito-android:${mockito_core}"
    val mockito_inline_testing = "org.mockito:mockito-inline:${mockito_inline}"
    val coroutine_testing = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${coroutine_testing_version}"
    val testlib_junit = "junit:junit:${junit}"
}