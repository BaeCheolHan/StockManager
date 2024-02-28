package kr.pe.hws.stock.api.index.controller

import kr.pe.hws.stock.api.kis.response.KrDailyIndexChartPriceWrapper

interface IndexSpec {

    fun getIndexChart(chartType: String)

    object Response {
        data class IndexChart (
            val kospi: KrDailyIndexChartPriceWrapper
        )
    }
}
