dependencies {
    // O 'app' depende de todos os outros módulos para conectar tudo
    implementation(project(":core"))
    implementation(project(":entrypoint"))
    implementation(project(":dataprovider"))

    // Dependência básica do Spring Boot
    implementation("org.springframework.boot:spring-boot-starter")

    // Dependências de desenvolvimento e runtime
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok")

    // Dependências para testes (Testcontainers fica aqui)
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.springframework.kafka:spring-kafka-test")

    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:kafka")
    testImplementation("org.testcontainers:mongodb")
    testImplementation("org.testcontainers:postgresql")
}
