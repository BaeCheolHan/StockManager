package kr.pe.hws.stock.adapter.feign.client

import kr.pe.hws.stock.adapter.feign.config.StockManagerFeignClientConfig
import kr.pe.hws.stock.exchange.rate.ExchangeRate
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "exchangeRateApiFeignClient",
    url = "https://quotation-api-cdn.dunamu.com",
    configuration = [StockManagerFeignClientConfig::class],
)
interface ExchangeRateApiFeignClient {
    @GetMapping("/v1/forex/recent")
    fun getExchangeRate(
        @SpringQueryMap param: ExchangeRateApi.Reqeust,
    ): List<ExchangeRate>
}

object ExchangeRateApi {
    data class Reqeust(
        val codes: String,
    )
}
