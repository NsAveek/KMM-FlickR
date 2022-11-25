object Compose {
    const val composeVersion = "1.2.1"
    const val compose_compiler_version = "1.3.2"
    private const val compose_version_viewmodel = "2.5.1"
    private const val compose_version_activity = "1.3.1"
    private const val compose_version_coil = "2.0.0-rc01"
    private const val compose_version_material3 = "1.0.0"
    private const val compose_navigation_version = "2.5.3"

    const val runtime = "androidx.compose.runtime:runtime:${composeVersion}"
    const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${composeVersion}"
    const val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${compose_version_viewmodel}"
    const val ui = "androidx.compose.ui:ui:${composeVersion}"
    const val material = "androidx.compose.material3:material3:${compose_version_material3}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${composeVersion}"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${composeVersion}"
    const val foundation = "androidx.compose.foundation:foundation:${composeVersion}"
    const val compiler = "androidx.compose.compiler:compiler:${compose_compiler_version}"
    const val activity_compose = "androidx.activity:activity-compose:${compose_version_activity}"
    const val coil_compose = "io.coil-kt:coil-compose:${compose_version_coil}"
    const val navigation = "androidx.navigation:navigation-compose:$compose_navigation_version"

}