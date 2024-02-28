package kr.pe.hws.stock.api.index.service

import kr.pe.hws.stock.adapter.feign.client.KisApiFeignClient
import kr.pe.hws.stock.adapter.feign.client.KisApiRequest
import kr.pe.hws.stock.adapter.util.KisApiUtils
import kr.pe.hws.stock.api.index.controller.IndexSpec
import kr.pe.hws.stock.api.index.controller.constants.IndexId
import kr.pe.hws.stock.api.kis.constants.KisApiTransactionId
import kr.pe.hws.stock.api.kis.response.DailyIndexChartPriceWrapper
import kr.pe.hws.stock.redis.hash.KrIndexChart
import kr.pe.hws.stock.redis.hash.OverSeaIndexChart
import kr.pe.hws.stock.redis.repository.KrIndexChartRepository
import kr.pe.hws.stock.redis.repository.OverSeaIndexChartRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class IndexService(
    val krIndexChartRepository: KrIndexChartRepository,
    val overSeaIndexChartRepository: OverSeaIndexChartRepository,
    val kisApiUtils: KisApiUtils,
    val kisApiFeignClient: KisApiFeignClient,
) {
    fun getIndexCharts(chartType: String): IndexSpec.Response.IndexChart {
        val kospiChart = getKRIndexChart(chartType, IndexId.KOSPI)
        val kosdaqChart = getKRIndexChart(chartType, IndexId.KOSDAQ)

        val snpChart = getOverSeaIndexChart(chartType, IndexId.SNP500)
        val nasdaqChart = getOverSeaIndexChart(chartType, IndexId.NASDAQ)
        val dawChart = getOverSeaIndexChart(chartType, IndexId.DAW)
        val philadelphiaChart = getOverSeaIndexChart(chartType, IndexId.PHILADELPHIA)

        return IndexSpec.Response.IndexChart(
            kospiChart,
            kosdaqChart,
            snpChart,
            nasdaqChart,
            dawChart,
            philadelphiaChart,
        )
    }

    fun getKRIndexChart(chartType: String, indexType: IndexId): DailyIndexChartPriceWrapper.KrDailyIndexChart {
        return krIndexChartRepository.findByIdOrNull("""${indexType.id}_$chartType""")
            ?.data
            ?: fetchKrIndexChartApi(chartType, indexType)
    }

    fun getOverSeaIndexChart(
        chartType: String,
        indexType: IndexId,
    ): DailyIndexChartPriceWrapper.OverSeaDailyIndexChart {
        return overSeaIndexChartRepository.findByIdOrNull("""${indexType.id}_$chartType""")
            ?.data
            ?: fetchOverSeaIndexChartApi(chartType, indexType)
    }

    fun fetchKrIndexChartApi(chartType: String, type: IndexId): DailyIndexChartPriceWrapper.KrDailyIndexChart {
        val headers = kisApiUtils.getDefaultApiHeader(KisApiTransactionId.KR_INDEX_CHART_PRICE.TRANSACTION_ID)
        val request = KisApiRequest.DailyIndexChartPriceRequest(
            "U",
            type.code,
            LocalDate.now().minusYears(100L).minusDays(1L).format(DateTimeFormatter.ofPattern("yyyyMMdd")),
            LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")),
            chartType,
        )
        val resp = kisApiFeignClient.getKrInquireDailyIndexChart(headers, request)
        val dfm = DateTimeFormatter.ofPattern("yyyyMMdd")
        resp.output2 = resp.output2.sortedWith { day1, day2 ->
            LocalDate.parse(day1.stckBsopDate, dfm).compareTo(LocalDate.parse(day2.stckBsopDate, dfm))
        }
        krIndexChartRepository.save(KrIndexChart("""${type.id}_$chartType""", resp))
        return resp
    }

    fun fetchOverSeaIndexChartApi(
        chartType: String,
        type: IndexId,
    ): DailyIndexChartPriceWrapper.OverSeaDailyIndexChart {
        val headers = kisApiUtils.getDefaultApiHeader(KisApiTransactionId.OVER_SEA_INDEX_CHART_PRICE.TRANSACTION_ID)
        val request = KisApiRequest.DailyIndexChartPriceRequest(
            "N",
            type.code,
            LocalDate.now().minusYears(100L).minusDays(1L).format(DateTimeFormatter.ofPattern("yyyyMMdd")),
            LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")),
            chartType,
        )
        val resp = kisApiFeignClient.getOverSeaInquireDailyChart(headers, request)
        val dfm = DateTimeFormatter.ofPattern("yyyyMMdd")
        resp.output2 = resp.output2.sortedWith { day1, day2 ->
            LocalDate.parse(day1.stckBsopDate, dfm).compareTo(LocalDate.parse(day2.stckBsopDate, dfm))
        }
        overSeaIndexChartRepository.save(OverSeaIndexChart("""${type.id}_$chartType""", resp))
        return resp
    }
}
