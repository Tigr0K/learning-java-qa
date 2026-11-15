plugins {
    id("java")
}

group = "com.learning"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("io.rest-assured:json-schema-validator:5.4.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.2")
}

tasks.test {
    useJUnitPlatform()
}