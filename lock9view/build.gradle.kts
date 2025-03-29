plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.takwolf.android.lock9view"
    compileSdk = 36

    defaultConfig {
        minSdk = 21

        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {
    compileOnly("androidx.annotation:annotation:1.9.1")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.takwolf.android.lock9view"
            artifactId = "lock9view"
            version = "0.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
