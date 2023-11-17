plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.sqldelight.runtime)

            implementation(libs.kotlinx.datetime)

            implementation(libs.koin.core)

            api(libs.moko.mvvm)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation(libs.sqldelight.android.driver)

            implementation(libs.koin.androidx.compose)
        }
        iosMain.dependencies {
            implementation(libs.sqldelight.native.driver)
        }
    }
}

sqldelight {
    databases {
        create("NoteDatabase") {
            packageName.set("com.example.notekmm")
            //WAŻNE: Pod source folderem musi być przynajmniej jeszcze jeden folder
            //w którym znajdują się pliki .sq
            //inaczej sqldelight nie wygeneruje klas, bo taki z niego
            //zajebisty ziomeczek :)))
            srcDirs("src/commonMain/database/noteDB")
        }
    }
}

android {
    namespace = "com.example.notekmm"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
}
