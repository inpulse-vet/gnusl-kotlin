buildscript {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
    }
    dependencies {
        val kotlinPluginVersion = libs.versions.kotlin.get()
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinPluginVersion")
    }
}

@Suppress("DSL_SCOPE_VIOLATION") // Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
}

allprojects {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }
    version = "1.0.0"
}
