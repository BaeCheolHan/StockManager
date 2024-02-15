package kr.pe.hws.stock.constants.stock

import java.math.BigDecimal

data class StockDividendHistory(
    val symbol: String,
    val date: String,
    val dividend: BigDecimal
)
