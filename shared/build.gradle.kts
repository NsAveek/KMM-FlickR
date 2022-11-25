plugins {
    kotlin(KotlinPlugin.multiplatform)
    kotlin(KotlinPlugin.cocoapods)
    kotlin(KotlinPlugin.serialization) version Kotlin.version
    id(Plugins.androidLibrary)
    id(Plugins.sqlDelight)

}


repositories {
     google()
     jcenter()
     mavenCentral()
//     maven { url "https://kotlin.bintray.com/kotlinx" }
 }


kotlin {
    android()
    iosX64()
    iosArm64()
    //iosSimulatorArm64() sure all ios dependencies support this target
    
    cocoapods {
        version = "1.0.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }



    sourceSets {
        val commonMain by getting {
            dependencies{
                implementation(Coroutine.coroutine)
                implementation("io.ktor:ktor-client-core:${Ktor.ktorVersion}")
                implementation("io.ktor:ktor-client-content-negotiation:${Ktor.ktorVersion}")
                implementation("io.ktor:ktor-serialization-kotlinx-json:${Ktor.ktorVersion}")
                implementation(SqlDelight.sqlDelightRuntime)
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${Kotlin.version}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting{
            dependencies {
                implementation("androidx.core:core-ktx:1.8.0")
//                implementation("androidx.core:core-ktx:${Ktx.coreKTX}")
                implementation("io.ktor:ktor-client-android:${Ktor.ktorVersion}")
                implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:${Ktx.viewModelKTX}")
                implementation(SqlDelight.sqlDelightAndroidDriver)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        //val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)

            dependencies {
                implementation("io.ktor:ktor-client-darwin:${Ktor.ktorVersion}")
                implementation(SqlDelight.sqlDelightiOSDriver)
//                implementation ("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:${Kotlin.version}")
            }
            //iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        //val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            //iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = Config.compileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
    }
}
sqldelight {
    database("AppDatabase") {
        packageName = "aveek.kmm_flickr.cache"
    }
}
kotlin.targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java) {
    binaries.all {
        binaryOptions["memoryModel"] = "experimental"
    }
}