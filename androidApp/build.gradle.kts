plugins {
    with(KotlinPlugin){
        kotlin(android)
    }
    id ("kotlin-kapt")
    id("com.android.application")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Config.compileSdk
    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.compose_compiler_version
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    hilt {
        enableAggregatingTask = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:${Ktx.viewModelKTX}")
    implementation("androidx.core:core-ktx:${Ktx.coreKTX}")
    with(Compose){
        implementation(runtime)
        implementation(runtimeLiveData)
        implementation(ui)
        implementation(material)
        implementation(uiTooling)
        implementation(foundation)
        implementation(compiler)
        implementation(activity_compose)
        implementation(lifecycleViewModelCompose)
        implementation(coil_compose)
        implementation(navigation)
    }
    implementation (Hilt.hiltAndroid)
    kapt (Hilt.androidx_hilt_kapt)

    implementation(Ktor.android)

    testImplementation (Testing.testlib_junit)
    testImplementation (Testing.core_testing)
    testImplementation (Testing.testlib_mockito)
    testImplementation (Testing.mockito_inline_testing)
    androidTestImplementation(Testing.mockito_android_testing)
    testImplementation (Testing.coroutine_testing)

}