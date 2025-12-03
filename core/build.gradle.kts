dependencies {
    // O core não deve ter dependências externas de frameworks!
    // Apenas bibliotecas puras, se necessário.
    // Adicionamos o Lombok para reduzir o boilerplate.
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}

tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}

tasks.named<Jar>("jar") {
    enabled = true
}

