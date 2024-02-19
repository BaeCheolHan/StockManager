rootProject.name = "StockManager"

include(
    "app:api",
    "infra:rdb",
    "infra:mongodb",
    "infra:redis",
    "domain",
    "infra:web-adapter",
)
