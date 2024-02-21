package kr.pe.hws.stock.adapter

import kr.pe.hws.stock.api.kis.request.KisApiRequest
import kr.pe.hws.stock.api.kis.response.KisApiResponseWrapper
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
    // 해외 개별 주식 상세
    @GetMapping("/uapi/overseas-price/v1/quotations/price-detail")
    fun getOverSeaStockPrice(
        @RequestHeader header: HttpHeaders,
        @SpringQueryMap param: KisApiRequest.OverSeaStockPriceRequest,
    ): KisApiResponseWrapper.OverSeaNowStockPriceResponse

    // 국내 개별 주식 상세
    @GetMapping("uapi/domestic-stock/v1/quotations/inquire-price")
    fun getKrStockPrice(
        @RequestHeader header: HttpHeaders,
        @SpringQueryMap param: KisApiRequest.KrStockPriceRequest,
    )

}
