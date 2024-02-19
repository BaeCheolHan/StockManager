dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation(Libraries.Kotlin.jackson)
    api(project(Modules.Infra.redis))
}
