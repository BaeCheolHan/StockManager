package kr.pe.hws.stock.adapter.feign.client

import kr.pe.hws.stock.adapter.feign.config.StockManagerFeignClientConfig
import kr.pe.hws.stock.api.kis.response.KrDailyIndexChartPriceWrapper
import kr.pe.hws.stock.api.kis.response.OverSeaNowStockPriceResponseWrapper
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
    ): OverSeaNowStockPriceResponseWrapper.OverSeaNowStockPriceResponse

    // 국내 개별 주식 상세
    @GetMapping("uapi/domestic-stock/v1/quotations/inquire-price")
    fun getKrStockPrice(
        @RequestHeader header: HttpHeaders,
        @SpringQueryMap param: KisApiRequest.KrStockPriceRequest,
    )

    // 국내주식 지수 api
    @GetMapping("uapi/domestic-stock/v1/quotations/inquire-daily-indexchartprice")
    fun getKrInquireDailyIndexChartPrice(
        @RequestHeader header: HttpHeaders,
        @SpringQueryMap param: KisApiRequest.KrDailyIndexChartPriceRequest,
    ): KrDailyIndexChartPriceWrapper.KrDailyIndexChartPrice

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
        val SYMB: String,
    )

    data class KrDailyIndexChartPriceRequest(
        // 조건 시장 분류 코드  :  업종 : U
        val FID_COND_MRKT_DIV_CODE: String,
        /**
         * 업종 상세코드
         * 0001 : 종합
         * 0002 : 대형주
         * ...
         * kis developer 포탈 (FAQ : 종목정보 다운로드 - 업종코드 참조)
         *
         * idxcode.xlsx 참고
         */
        val FID_INPUT_ISCD: String,
        val FID_INPUT_DATE_1: String,
        val FID_INPUT_DATE_2: String,
        val FID_PERIOD_DIV_CODE: String,
        )
}

