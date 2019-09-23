plugins {
    id("org.springframework.boot") version "2.1.3.RELEASE"
}

tasks.withType<Jar> {
    enabled = true
}

dependencies {
    "implementation"("org.jetbrains.exposed:exposed:${Shared.EXPOSED_VERSION}")
    "implementation"("com.relops:snowflake:1.1")
}