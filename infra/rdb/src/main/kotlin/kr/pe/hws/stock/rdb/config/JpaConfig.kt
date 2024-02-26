package kr.pe.hws.stock.rdb.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(basePackages = ["kr.pe.hws.stock.rdb"])
@EntityScan("kr.pe.hws.stock.rdb")
class JpaConfig(
    val datasource: DataSource,
)
