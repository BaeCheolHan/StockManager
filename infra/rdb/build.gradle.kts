plugins {
    kotlin("plugin.jpa") version Versions.kotlin
    kotlin("kapt") version Versions.kotlin
    idea
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

kapt {
    correctErrorTypes = true
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    api(Libraries.Spring.bootStarterDataJpa)
    api(project(Modules.domain))
    implementation("org.mariadb.jdbc:mariadb-java-client:3.3.2")

    // QueryDSL 설정
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
    kapt("jakarta.annotation:jakarta.annotation-api")
    kapt("jakarta.persistence:jakarta.persistence-api")
}

idea {
    module {
        val kaptMain = file("$layout.buildDirectory/generated/querydsl")
        sourceDirs.add(kaptMain)
        generatedSourceDirs.add(kaptMain)
    }
}

tasks.register<Copy>("copy-dev") {
    from(file("$projectDir/../../StockManager-private/resources/dev/application-rdb.yml"))
    into("$projectDir/src/main/resources")
}

tasks.register<Copy>("copy-prod") {
    from(file("$projectDir/../../StockManager-private/resources/prod/application-rdb.yml"))
    into("$projectDir/src/main/resources")
}
