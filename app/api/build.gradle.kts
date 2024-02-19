dependencyManagement {
    imports {
        mavenBom(Libraries.Spring.cloud)
    }
}

dependencies {
    implementation(Libraries.Spring.bootStarter)
    implementation(Libraries.Spring.bootStarterWeb)
    implementation(Libraries.Kotlin.reflect)
    implementation(project(Modules.domain))
    implementation(project(Modules.Infra.webAdapter))
    api(project(Modules.Infra.rdb))
    api(project(Modules.Infra.redis))
    api(project(Modules.Infra.mongodb))
    implementation(Libraries.Kotlin.jackson)
}
