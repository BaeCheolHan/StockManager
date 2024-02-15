dependencies {
    api(Libraries.Spring.bootStarterDataMongodb)
    api(project(Modules.domain))
}

tasks.register<Copy>("copy-dev") {
    delete("/src/main/resources")
    from(file("../../StockManager-private/resources/dev/application-mongodb.yml"))
    into("/src/main/resources")
}

tasks.register<Copy>("copy-prod") {
    delete("/src/main/resources")
    from(file("../../StockManager-private/resources/prod/application-mongodb.yml"))
    into("/src/main/resources")
}

