package kr.pe.hws.stock.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication(scanBasePackages = ["kr.pe.hws.stock"])
@EnableFeignClients(basePackages = ["kr.pe.hws.stock"])
class InternalApiApplication

fun main(args: Array<String>) {
    runApplication<InternalApiApplication>(*args)
}
