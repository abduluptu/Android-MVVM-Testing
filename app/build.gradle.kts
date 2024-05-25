plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.soha.infotech.androidmvvmtesting"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.soha.infotech.androidmvvmtesting"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        // To resolve MainViewModelFactory issue
        //freeCompilerArgs = ['-Xjvm-default=compatibility']
        val freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }

    // To share data between both test directories
    /*sourceSets{
         androidTest{
             java.srcDirs += "src/sharedTest/java"
         }
         test{
             java.srcDirs += "src/sharedTest/java"
         }
     }*/
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Step1:  Added dependencies

    // core testing
    testImplementation(libs.androidx.core.testing)
    androidTestImplementation(libs.core.testing.v210)

    // retrofit, okhttp, logging, gson
    implementation(libs.retrofit)
    implementation(libs.okhttp.v472)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.gson)
    implementation(libs.gson.v286)

    // coroutines
    implementation(libs.kotlinx.coroutines.core.v173)
    implementation(libs.kotlinx.coroutines.android.v173)
    testImplementation(libs.kotlinx.coroutines.test.v173)

    // lifecycle, viewmodel & livedata
    implementation(libs.lifecycle.viewmodel.ktx)

    // glide
    implementation(libs.glide.v4120)
    kapt(libs.compiler.v4120)

    // mock webserver
    testImplementation(libs.mockwebserver)

    // mockito
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
}