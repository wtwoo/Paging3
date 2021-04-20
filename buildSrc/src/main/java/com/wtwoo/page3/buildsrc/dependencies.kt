package com.wtwoo.page3.buildsrc

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:4.1.0"
    const val timber = "com.jakewharton.timber:timber:4.7.1"

    const val junit = "junit:junit:4.13"
    const val robolectric = "org.robolectric:robolectric:4.3.1"

    object Mdc {
        const val material = "com.google.android.material:material:1.3.0"
    }

    object Google {
        const val gson = "com.google.code.gson:gson:2.8.5"
    }

    object Kotlin {
        private const val version = "1.4.20"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.0-alpha05"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0-alpha01"
        const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"
        const val multidex = "androidx.multidex:multidex:2.0.1"

        object Hilt {
            private const val version = "1.0.0-alpha02"
            const val work = "androidx.hilt:hilt-work:$version"
            const val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
        }

        object Navigation {
            private const val version = "2.3.0"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Test {
            private const val version = "1.2.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        }

        object Paging {
            private const val version = "3.0.0-alpha11"
            const val common = "androidx.paging:paging-common-ktx:$version"
            const val runtime = "androidx.paging:paging-runtime-ktx:$version"
            const val rxjava2 = "androidx.paging:paging-rxjava2-ktx:$version"
        }
    }

    object Dagger {
        private const val version = "2.28.3"
        const val dagger = "com.google.dagger:dagger:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
    }

    object Hilt {
        private const val version = "2.28.3-alpha"
        const val library = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    object Coil {
        private const val version = "1.1.1"
        const val coil = "io.coil-kt:coil:$version"
    }

    object RxJava2 {
        private const val version = "2.2.17"
        const val rxjava = "io.reactivex.rxjava2:rxjava:$version"
        const val rxandroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
        const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
        const val rxbinding = "com.jakewharton.rxbinding3:rxbinding:3.0.0-alpha2"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
        const val rxjava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
    }

    object OkHttp {
        private const val version = "4.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val urlconnection = "com.squareup.okhttp3:okhttp-urlconnection:$version"
    }

    object Lottie {
        private const val version = "3.7.0"
        const val lottie = "com.airbnb.android:lottie:$version"
    }

    object Chucker {
        private const val version = "3.4.0"
        const val chucker = "com.github.chuckerteam.chucker:library:$version"
        const val chucker_no_op = "com.github.chuckerteam.chucker:library-no-op:$version"
    }
}