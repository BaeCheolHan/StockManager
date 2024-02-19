package kr.pe.hws.stock

import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication(scanBasePackages = ["kr.pe.hws.stock"])
@EnableFeignClients(basePackages = ["kr.pe.hws.stock"])
class StockManagerApplication {
}
