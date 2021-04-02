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
            const val runtime = "androidx.paging:paging-runtime-ktx:$version"
            const val rxjava2 = "androidx.paging:paging-rxjava2-ktx:$version"
        }
    }

    object Koin {
        private const val version = "2.2.2"
        const val viewmodel = "org.koin:koin-androidx-viewmodel:$version"
        const val fragment = "org.koin:koin-androidx-fragment:$version"
        const val scope = "org.koin:koin-androidx-scope:$version"
        const val extCore = "org.koin:koin-core-ext:$version"
    }

    object Glide {
        private const val version = "4.11.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
        const val lifecycleCompiler = "android.arch.lifecycle:compiler:1.0.0"
        const val transformations = "jp.wasabeef:glide-transformations:4.2.0"
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
}