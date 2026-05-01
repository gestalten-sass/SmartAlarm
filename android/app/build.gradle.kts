import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

val keyPropertiesFile = rootProject.file("key.properties")
val keyProperties = Properties()
if (keyPropertiesFile.exists()) {
    keyProperties.load(FileInputStream(keyPropertiesFile))
}

val envFile = rootProject.file("../.env")
val envProperties = Properties()
if (envFile.exists()) {
    envProperties.load(FileInputStream(envFile))
}

fun signingValue(envKey: String, keyProp: String): String {
    return (envProperties.getProperty(envKey)
        ?: keyProperties.getProperty(keyProp)
        ?: "").trim()
}

android {
    namespace = "de.norbertsass.smart_alarm"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    defaultConfig {
        applicationId = "de.norbertsass.smart_alarm"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    signingConfigs {
        create("release") {
            keyAlias = signingValue("SMART_ALARM_KEY_ALIAS", "keyAlias")
            keyPassword = signingValue("SMART_ALARM_KEY_PASSWORD", "keyPassword")
            storePassword = signingValue("SMART_ALARM_STORE_PASSWORD", "storePassword")
            val storeFilePath = signingValue("SMART_ALARM_STORE_FILE", "storeFile")
            if (storeFilePath.isNotEmpty()) {
                storeFile = file(storeFilePath)
            }
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    implementation("com.google.android.material:material:1.12.0")
}
