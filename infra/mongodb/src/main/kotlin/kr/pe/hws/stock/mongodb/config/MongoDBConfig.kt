package kr.pe.hws.stock.mongodb.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(basePackages = ["kr.pe.hws.stock.mongodb"])
class MongoDBConfig
