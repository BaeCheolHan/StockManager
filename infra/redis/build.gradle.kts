dependencies {
    api(Libraries.Spring.bootStarterDataRedis)
    api(project(Modules.domain))
    implementation("org.springframework.session:spring-session-data-redis")
}

tasks.register<Copy>("copy-dev") {
    from(file("$projectDir/../../StockManager-private/resources/dev/application-redis.yml"))
    into("$projectDir/src/main/resources")
}

tasks.register<Copy>("copy-prod") {
    from(file("$projectDir/../../StockManager-private/resources/prod/application-redis.yml"))
    into("$projectDir/src/main/resources")
}
