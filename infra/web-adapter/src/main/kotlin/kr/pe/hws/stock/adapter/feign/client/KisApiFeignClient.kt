package kr.pe.hws.stock.adapter.feign.client

import kr.pe.hws.stock.adapter.feign.config.StockManagerFeignClientConfig
import kr.pe.hws.stock.api.kis.response.DailyIndexChartPriceWrapper
import kr.pe.hws.stock.api.kis.response.OverSeaNowStockPriceResponseWrapper
import kr.pe.hws.stock.api.token.ApiToken
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    name = "kisApiFeignClient",
    url = "https://openapi.koreainvestment.com:9443",
    configuration = [StockManagerFeignClientConfig::class],
)
interface KisApiFeignClient {
    @PostMapping("/oauth2/tokenP", consumes = ["application/json"])
    fun getKisApiToken(@RequestBody param: KisApiRequest.KisTokenGenerateRequest): ApiToken.KisToken

    // 해외 개별 주식 상세
    @GetMapping("/uapi/overseas-price/v1/quotations/price-detail")
    fun getOverSeaStockPrice(
        @RequestHeader header: HttpHeaders,
        @SpringQueryMap param: KisApiRequest.OverSeaStockPriceRequest,
    ): OverSeaNowStockPriceResponseWrapper.OverSeaNowStockPriceResponse

    // 국내 개별 주식 상세
    @GetMapping("/uapi/domestic-stock/v1/quotations/inquire-price")
    fun getKrStockPrice(
        @RequestHeader header: HttpHeaders,
        @SpringQueryMap param: KisApiRequest.KrStockPriceRequest,
    )

    // 국내 지수 api
    @GetMapping("/uapi/domestic-stock/v1/quotations/inquire-daily-indexchartprice")
    fun getKrInquireDailyIndexChart(
        @RequestHeader header: HttpHeaders,
        @SpringQueryMap param: KisApiRequest.DailyIndexChartPriceRequest,
    ): DailyIndexChartPriceWrapper.KrDailyIndexChart

    // 해외 지수 api
    @GetMapping("/uapi/overseas-price/v1/quotations/inquire-daily-chartprice")
    fun getOverSeaInquireDailyChart(
        @RequestHeader header: HttpHeaders,
        @SpringQueryMap param: KisApiRequest.DailyIndexChartPriceRequest,
    ): DailyIndexChartPriceWrapper.OverSeaDailyIndexChart
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

    data class DailyIndexChartPriceRequest(
        //
        /**
         * -------------- KR --------------
         * 조건 시장 분류 코드  :  업종 : U
         * -------------- KR --------------
         *
         * ----------- OVER_SEA -----------
         * FID 조건 시장 분류 코드, N: 해외지수, X 환율
         */
        val FID_COND_MRKT_DIV_CODE: String,
        /**
         * ---------------------------- KR ----------------------------
         * 업종 상세코드
         * 0001 : 종합
         * 0002 : 대형주
         * ...
         * kis developer 포탈 (FAQ : 종목정보 다운로드 - 업종코드 참조)
         *
         * idxcode.xlsx 참고
         * ---------------------------- KR ----------------------------
         *
         * ------------------------- OVER_SEA -------------------------
         * FID 입력 종목코드
         * 	종목코드
         * ※ 해외주식 마스터 코드 참조
         * (포럼 > FAQ > 종목정보 다운로드 > 해외주식)
         *
         * 해당 API로 미국주식 조회 시, 다우30, 나스닥100, S&P500 종목만 조회 가능합니다.
         * 더 많은 미국주식 종목 시세를 이용할 시에는, 해외주식기간별시세 API 사용 부탁드립니다.
         * ------------------------- OVER_SEA -------------------------
         */
        val FID_INPUT_ISCD: String,
        // 시작일자(YYYYMMDD)
        val FID_INPUT_DATE_1: String,
        // 	종료일자(YYYYMMDD)
        val FID_INPUT_DATE_2: String,
        // FID 기간 분류 코드 D:일, W:주, M:월, Y:년
        val FID_PERIOD_DIV_CODE: String,
    )
}
