dependencyManagement {
    imports {
        mavenBom(Libraries.Spring.cloud)
    }
}

dependencies {
    implementation(project(Modules.domain))
    api(project(Modules.Infra.redis))
    api(Libraries.Spring.openfeign)
    implementation(Libraries.Spring.bootStarterWeb)
    implementation(Libraries.Kotlin.jackson)
}

tasks.register<Copy>("copy-dev") {
    from(file("$projectDir/../../StockManager-private/resources/dev/application-api.yml"))
    into("$projectDir/src/main/resources")
}

tasks.register<Copy>("copy-prod") {
    from(file("$projectDir/../../StockManager-private/resources/prod/application-api.yml"))
    into("$projectDir/src/main/resources")
}
