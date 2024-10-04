dependencyManagement {
    imports {
        mavenBom(Libraries.Spring.cloud)
    }
}

dependencies {
    implementation(Libraries.Spring.bootStarter)
    implementation(Libraries.Spring.bootStarterWeb)
//    api(Libraries.Spring.openfeign)
    implementation(Libraries.Kotlin.reflect)
    implementation(project(Modules.domain))
    api(project(Modules.Infra.rdb))
    api(project(Modules.Infra.redis))
    api(project(Modules.Infra.mongodb))
    api(project(Modules.Infra.webAdapter))
    implementation(Libraries.Kotlin.jackson)
}

tasks.register<Copy>("copy-dev") {
    from(file("$projectDir/../../StockManager-private/resources/dev/application-sns.yml"))
    into("/src/main/resources")
}

tasks.register<Copy>("copy-prod") {
    from(file("$projectDir/../../StockManager-private/resources/prod/application-sns.yml"))
    into("$projectDir/src/main/resources")
}

tasks.register("printProjectDir") {
    doLast {
        println("Project directory: $projectDir")
    }
}
