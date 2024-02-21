package kr.pe.hws.stock.adapter

import kr.pe.hws.stock.api.kis.request.OverSeaStockPriceRequest
import kr.pe.hws.stock.api.kis.response.OverSeaNowStockPriceWrapper
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    name = "kisApiFeignClient",
    url = "https://openapi.koreainvestment.com:9443",
    configuration = [StockManagerFeignClientConfig::class],
)
interface KisApiFeignClient {
    @GetMapping("/uapi/overseas-price/v1/quotations/price-detail")
    fun getOverSeaStockPrice(
        @RequestHeader header: HttpHeaders,
        @SpringQueryMap param: OverSeaStockPriceRequest,
    ): OverSeaNowStockPriceWrapper
}
