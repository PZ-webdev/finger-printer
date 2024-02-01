plugins {
    id("java")
}

group = "com.pzwebdev"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_19
    targetCompatibility = JavaVersion.VERSION_19
}

repositories {
    mavenCentral()
}

dependencies {
    // Core.
    implementation("org.springframework.boot:spring-boot-starter:3.1.0")
    compileOnly("org.projectlombok:lombok:1.18.26")

    // Tests.
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}

tasks.test {
    useJUnitPlatform()
}