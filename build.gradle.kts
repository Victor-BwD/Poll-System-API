plugins {
	java
	id("org.springframework.boot") version "4.0.0" apply false
	id("io.spring.dependency-management") version "1.1.7" apply false
}

subprojects {

    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    group = "br.com.victorbwd"
    version = "0.0.1-SNAPSHOT"

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
    }

    dependencies {
        testImplementation(platform("org.testcontainers:testcontainers-bom:1.20.4"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()

        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}

