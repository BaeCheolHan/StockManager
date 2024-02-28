package kr.pe.hws.stock.api.index.service

import kr.pe.hws.stock.adapter.feign.client.KisApiFeignClient
import kr.pe.hws.stock.adapter.feign.client.KisApiRequest
import kr.pe.hws.stock.adapter.util.KisApiUtils
import kr.pe.hws.stock.api.index.controller.constants.IndexId
import kr.pe.hws.stock.api.kis.constants.KisApiTransactionId
import kr.pe.hws.stock.api.kis.response.KrDailyIndexChartPriceWrapper
import kr.pe.hws.stock.redis.hash.KrIndexChart
import kr.pe.hws.stock.redis.repository.KrIndexChartRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class IndexService(
    val krIndexChartRepository: KrIndexChartRepository,
    val kisApiUtils: KisApiUtils,
    val kisApiFeignClient: KisApiFeignClient,
) {
    fun getIndexCharts(chartType: String) {
        val kospiChart = getKrIndexChart(chartType, IndexId.KOSPI)
        val kosdaqChart = getKrIndexChart(chartType, IndexId.KOSDAQ)
    }

    fun getKrIndexChart(chartType: String, type: IndexId) {
        val resp = krIndexChartRepository.findByIdOrNull("""${type.id}_$chartType""")
            ?.data
            ?: fetchKrIndexChartApi(chartType, type)

        println(resp)
    }

    fun fetchKrIndexChartApi(chartType: String, type: IndexId): KrDailyIndexChartPriceWrapper.KrDailyIndexChartPrice {
        val headers = kisApiUtils.getDefaultApiHeader(KisApiTransactionId.KR_INDEX_CHART_PRICE.transactionId)
        val request = KisApiRequest.KrDailyIndexChartPriceRequest(
            "U",
            type.code,
            LocalDate.now().minusYears(100L).minusDays(1L).format(DateTimeFormatter.ofPattern("yyyyMMdd")),
            LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")),
            chartType,
        )
        val resp = kisApiFeignClient.getKrInquireDailyIndexChartPrice(headers, request)
        krIndexChartRepository.save(KrIndexChart("""${type.id}_$chartType""", resp))
        return resp
    }
}
