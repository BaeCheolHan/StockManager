package kr.pe.hws.stock.api.kis.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

object DailyIndexChartPriceWrapper {

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class KrDailyIndexChart(
        val rtCd: String,
        val msgCd: String,
        val msg1: String,
        val output1: KrDailyIndexChartOutput1,
        var output2: List<KrDailyIndexChartOutput2>,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class KrDailyIndexChartOutput1(
        // 업종 전일 최저가
        val futsPrdyLwpr: String?,
        // 업종 전일 최고가
        val futsPrdyHgpr: String?,
        // 업종 전일 시가
        val futsPrdyOprc: String?,
        // 업종 지수 최저가
        val bstpNmixLwpr: String?,
        // 업종 지수 최고가
        val bstpNmixHgpr: String?,
        // 업종 지수 시가
        val bstpNmixOprc: String?,
        // 전일 거래량
        val prdyVol: String?,
        // 업종 구분 코드
        val bstpClsCode: String?,
        // 업종 지수 현재가
        val bstpNmixPrpr: String?,
        // HTS 한글 종목명
        val htsKorIsnm: String?,
        // 누적 거래 대금
        val acmlTrPbmn: String?,
        // 전일 지수
        val prdyNmix: String?,
        // 업종 지수 전일 대비율
        val bstpNmixPrdyCtrt: String?,
        // 전일 대비 부호
        //  1 : 상한
        //  2 : 상승
        //  3 : 보합
        //  4 : 하한
        //  5 : 하락
        val prdyVrssSign: String?,
        // 업종 지수 전일 대비
        val bstpNmixPrdyVrss: String?,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class KrDailyIndexChartOutput2(
        // 누적 거래 대금
        val acmlTrPbmn: String?,
        // 누적 거래량
        val acmlVol: String?,
        // 업종 지수 최저가
        val bstpNmixLwpr: String?,
        // 업종 지수 최고가
        val bstpNmixHgpr: String?,
        // 업종 지수 시가
        val bstpNmixOprc: String?,
        // 업종 지수 현재가
        val bstpNmixPrpr: String?,
        // 영업 일자
        val stckBsopDate: String?,
        // 변경 여부
        val modYn: String?,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class OverSeaDailyIndexChart(
        val rtCd: String,
        val msgCd: String,
        val msg1: String,
        val output1: OverSeaDailyIndexChartOutput1,
        var output2: List<OverSeaDailyIndexChartOutput2>,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class OverSeaDailyIndexChartOutput1(
        // 전일 대비
        val ovrsNmixPrdyVrss: String?,
        // 전일 대비 부호
        // 	1 : 상한
        //  2 : 상승
        //  3 : 보합
        //  4 : 하한
        //  5 : 하락
        val prdyVrssSign: String?,
        // 전일 대비율
        val prdyCtrt: String?,
        // 전일 종가
        val ovrsNmixPrdyClpr: String?,
        // 누적 거래량
        val acmlVol: String?,
        // HTS 한글 종목명
        val htsKorIsnm: String?,
        // 현재가
        val ovrsNmixPrpr: String?,
        // 단축 종목코드
        val stckShrnIscd: String?,
        // 시가
        val ovrsProdOprc: String?,
        // 최고가
        val ovrsProdHgpr: String?,
        // 최저가
        val ovrsProdLwpr: String?,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class OverSeaDailyIndexChartOutput2(
        // 조회 일자
        val stckBsopDate: String?,
        // 현재가
        val ovrsNmixPrpr: String?,
        // 시작가
        val ovrsNmixOprc: String?,
        // 최고가
        val ovrsNmixHgpr: String?,
        // 최저가
        val ovrsNmixLwpr: String?,
        // 거래량
        val acmlVol: String?,
        val modYn: String?,
    )
}
