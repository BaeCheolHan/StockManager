plugins {
    kotlin("plugin.jpa") version Versions.kotlin
}

dependencies {
    api(Libraries.Spring.bootStarterDataJpa)
    api(project(Modules.domain))
    implementation("org.mariadb.jdbc:mariadb-java-client:3.3.2")
}

tasks.register<Copy>("copy") {
    delete("/src/main/resources")
    from(file("../../StockManager-private/resources"))
    include("*.yml")
    into("/src/main/resources")
}

