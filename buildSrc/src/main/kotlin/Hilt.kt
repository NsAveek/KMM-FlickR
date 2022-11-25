object Hilt {
    const val version = "2.42"
    const val hiltAndroid = "com.google.dagger:hilt-android:$version"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:$version"
    const val androidx_hilt_kapt = "com.google.dagger:hilt-android-compiler:$version"
    const val androidx_hilt_classpath =
        "com.google.dagger:hilt-android-gradle-plugin:$version"
    private const val hiltNavigationVersion = "1.0.0-alpha03"
    const val hiltNavigation = "androidx.hilt:hilt-navigation:$hiltNavigationVersion"
}