package kr.pe.hws.stock.api.index.controller

import kr.pe.hws.stock.api.kis.response.DailyIndexChartPriceWrapper

interface IndexSpec {

    fun getIndexChart(chartType: String): Response.IndexChart

    object Response {
        data class IndexChart (
            val kospi: DailyIndexChartPriceWrapper.KrDailyIndexChart,
            val kosdaq: DailyIndexChartPriceWrapper.KrDailyIndexChart,
            val snp: DailyIndexChartPriceWrapper.OverSeaDailyIndexChart,
            val nasdaq: DailyIndexChartPriceWrapper.OverSeaDailyIndexChart,
            val daw: DailyIndexChartPriceWrapper.OverSeaDailyIndexChart,
            val philadelphia: DailyIndexChartPriceWrapper.OverSeaDailyIndexChart,
        )
    }
}
