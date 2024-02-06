import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("co.touchlab.skie") version "0.6.1"
    kotlin("plugin.serialization") version "1.9.20"
    alias(libs.plugins.sqlDelight)
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
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.kotlinx.datetime)
            implementation(libs.koin.core)
            implementation(libs.sql.coroutines.extensions)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation(libs.sql.native.driver)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.android)
            implementation (libs.androidx.lifecycle.viewmodel.ktx)
            implementation(libs.sql.android.driver)

        }
    }
}

android {
    project.extensions.findByType(KotlinMultiplatformExtension::class.java)?.apply {
        targets
            .filterIsInstance<KotlinNativeTarget>()
            .flatMap { it.binaries }
            .forEach { compilationUnit -> compilationUnit.linkerOpts("-lsqlite3") }
    }
    namespace = "com.example.newstestkmp"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
    }
}
sqldelight {
    databases {
        create(name = "NewsTestDatabase") {
            packageName.set("com.example.newstestkmp.db")
        }
    }
    linkSqlite = true
}

