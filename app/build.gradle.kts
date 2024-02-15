dependencyManagement {
    imports {
        mavenBom(Libraries.Spring.cloud)
    }
}

dependencies {
    implementation(Libraries.Spring.bootStarter)
    implementation(Libraries.Spring.bootStarterWeb)
    implementation(Libraries.Kotlin.reflect)
    api(project(Modules.Infra.rdb))
    implementation(Libraries.Kotlin.jackson)
}
