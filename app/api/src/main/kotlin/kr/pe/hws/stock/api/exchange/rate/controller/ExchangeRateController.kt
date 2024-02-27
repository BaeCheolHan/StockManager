package kr.pe.hws.stock.api.exchange.rate.controller

import kr.pe.hws.stock.api.exchange.rate.service.ExchangeRateService
import kr.pe.hws.stock.exchange.rate.ExchangeRate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/exchange-rate")
class ExchangeRateController(
    val exchangeRateService: ExchangeRateService,
) {

    @GetMapping
    fun getExchangeRate(): ExchangeRate {
        return exchangeRateService.getExchangeRate()
    }
}
