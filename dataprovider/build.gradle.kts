dependencies {
    // Depende do módulo 'core' para acessar as interfaces dos casos de uso
    implementation(project(":core"))

    // Dependência para criar APIs REST (controllers)
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}

tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}

tasks.named<Jar>("jar") {
    enabled = true
}

