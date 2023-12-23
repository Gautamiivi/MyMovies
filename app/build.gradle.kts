plugins {
    id("com.android.application")
}



android {
    namespace = "com.mycode.mymovies"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mycode.mymovies"
        minSdk = 24
        targetSdk = 33
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
    buildFeatures{
        dataBinding=true
    }

}

dependencies {
    //lifecycle
        // ViewModel
        implementation ("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
        // LiveData
        implementation ("androidx.lifecycle:lifecycle-livedata:2.6.2")
        // Lifecycles only (without ViewModel or LiveData)
        implementation ("androidx.lifecycle:lifecycle-runtime:2.6.2")

        // Saved state module for ViewModel
        implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.2")

        // Annotation processor
        annotationProcessor ("androidx.lifecycle:lifecycle-compiler:2.6.2")
        // alternately - if using Java8, use the following instead of lifecycle-compiler
        implementation ("androidx.lifecycle:lifecycle-common-java8:2.6.2")

        // optional - helpers for implementing LifecycleOwner in a Service
        implementation ("androidx.lifecycle:lifecycle-service:2.6.2")

        // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
        implementation ("androidx.lifecycle:lifecycle-process:2.6.2")

        // optional - ReactiveStreams support for LiveData
        implementation ("androidx.lifecycle:lifecycle-reactivestreams:2.6.2")

        // optional - Test helpers for LiveData
        testImplementation ("androidx.arch.core:core-testing:2.6.2")

        // optional - Test helpers for Lifecycle runtime
        testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:2.6.2")



    //hilt dagger dependency
    implementation ("com.google.dagger:hilt-android:2.49")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.49")

   // paging_version = "3.2.1"
    implementation ("androidx.paging:paging-runtime:3.2.1")
    // alternatively - without Android dependencies for tests
    testImplementation ("androidx.paging:paging-common:3.2.1")
    // optional - RxJava2 support
    implementation ("androidx.paging:paging-rxjava2:3.2.1")
    // optional - RxJava3 support
    implementation ("androidx.paging:paging-rxjava3:3.2.1")
    // optional - Guava ListenableFuture support
    implementation ("androidx.paging:paging-guava:3.2.1")
    // optional - Jetpack Compose integration
    implementation ("androidx.paging:paging-compose:3.3.0-alpha02")

    //glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation("androidx.databinding:databinding-runtime:8.2.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:(2.9.0)")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.google.code.gson:gson:2.9.0")
    //swipe to refresh
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")

    //solving duplicate class error
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}