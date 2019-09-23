import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version Shared.KOTLIN_VERSION

    id("com.github.ben-manes.versions") version "0.20.0"
}

allprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.javaParameters = true
    }
}

subprojects {
    apply(plugin = "kotlin")

    configurations.all {
        resolutionStrategy.preferProjectModules()
    }

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        "implementation"("com.google.inject:guice:4.2.2")
    }
}