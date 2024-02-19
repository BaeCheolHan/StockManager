plugins {
    kotlin("plugin.jpa") version Versions.kotlin
    kotlin("kapt") version "1.8.21"
    idea
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
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
        val kaptMain = file("build/generated/source/kapt/main")
        sourceDirs.add(kaptMain)
        generatedSourceDirs.add(kaptMain)
    }
}

tasks.register<Copy>("copy-dev") {
    delete("/src/main/resources")
    from(file("../../StockManager-private/resources/dev/application-rdb.yml"))
    into("/src/main/resources")
}

tasks.register<Copy>("copy-prod") {
    delete("/src/main/resources")
    from(file("../../StockManager-private/resources/prod/application-rdb.yml"))
    into("/src/main/resources")
}
