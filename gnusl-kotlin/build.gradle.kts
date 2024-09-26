plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    mingwX64()
    androidTarget()
}

android {
    namespace = "vet.inpulse.gnusl"
    compileSdk = 34
}