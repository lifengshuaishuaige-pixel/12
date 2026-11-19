plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0"
}

android {
    namespace = "com.example.recipeapp"
    compileSdk = rootProject.ext.get("compileSdk") as Int

    defaultConfig {
        applicationId = "com.example.recipeapp"
        minSdk = rootProject.ext.get("minSdk") as Int
        targetSdk = rootProject.ext.get("targetSdk") as Int
        versionCode = rootProject.ext.get("versionCode") as Int
        versionName = rootProject.ext.get("versionName") as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.ext.get("composeBomVersion") as String
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,LICENSE,NOTICE}"
        }
    }
}

dependencies {
    // Android Core
    implementation("androidx.core:core-ktx:${rootProject.ext.get("coreKtxVersion")}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${rootProject.ext.get("lifecycleVersion")}")
    implementation("androidx.activity:activity-compose:${rootProject.ext.get("activityComposeVersion")}")

    // Compose BOM
    val composeBom = platform("androidx.compose:compose-bom:${rootProject.ext.get("composeBomVersion")}")
    implementation(composeBom)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-window-size-class")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.compose.runtime:runtime-rxjava2")

    // Material3
    implementation("com.google.android.material:material:${rootProject.ext.get("material3Version")}")

    // Navigation
    implementation("androidx.navigation:navigation-compose:${rootProject.ext.get("navigationVersion")}")

    // Room Database
    val roomVersion = rootProject.ext.get("roomVersion") as String
    implementation("androidx.room:room-runtime:${roomVersion}")
    implementation("androidx.room:room-ktx:${roomVersion}")
    kapt("androidx.room:room-compiler:${roomVersion}")

    // Hilt Dependency Injection
    val hiltVersion = rootProject.ext.get("hiltVersion") as String
    implementation("com.google.dagger:hilt-android:${hiltVersion}")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    kapt("com.google.dagger:hilt-compiler:${hiltVersion}")

    // Coil Image Loading
    implementation("io.coil-kt:coil-compose:${rootProject.ext.get("coilVersion")}")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}