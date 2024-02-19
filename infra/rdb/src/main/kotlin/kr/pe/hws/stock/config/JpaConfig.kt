package kr.pe.hws.stock.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories(basePackages = ["kr.pe.hws.stock"])
@EntityScan("kr.pe.hws.stock")
class JpaConfig(
    val datasource: DataSource,
)
