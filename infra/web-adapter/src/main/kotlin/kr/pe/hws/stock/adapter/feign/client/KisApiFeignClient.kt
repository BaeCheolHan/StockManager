package kr.pe.hws.stock.adapter.feign.client

import kr.pe.hws.stock.adapter.feign.config.StockManagerFeignClientConfig
import kr.pe.hws.stock.api.kis.response.KisApiResponseWrapper
import kr.pe.hws.stock.api.token.ApiToken
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    name = "kisApiFeignClient",
    url = "https://openapi.koreainvestment.com:9443",
    configuration = [StockManagerFeignClientConfig::class],
)
interface KisApiFeignClient {
    @PostMapping("/oauth2/tokenP")
    fun getKisApiToken(param: KisApiRequest.KisTokenGenerateRequest): ApiToken.KisToken

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

object KisApiRequest {

    data class KisTokenGenerateRequest(
        val grant_type: String,
        val appkey: String,
        val appsecret: String,
    ) {
        constructor(appKey: String, appSecret: String) : this("client_credentials", appKey, appSecret)
    }

    data class KrStockPriceRequest(
        val fid_cond_mrkt_div_code: String,
        val fid_input_iscd: String,
    )

    data class OverSeaStockPriceRequest(
        val AUTH: String,
        val EXCD: String,
        val SYMB: String
    )
}

