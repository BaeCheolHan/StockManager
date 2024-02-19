plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "StockManager"

include(
    "infra:rdb",
    "infra:mongodb",
    "infra:redis",
    "domain",
    "infra:web-adapter",
    "app:api",
)
