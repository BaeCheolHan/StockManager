package kr.pe.hws.stock.constants.stock

import java.math.BigDecimal

data class DashboardStock(
    val symbol: String,
    val code: String,
    val national: String,
    val name: String,
    val avgPrice: BigDecimal,
    val quantity: BigDecimal,
    val totalDividend: BigDecimal,
    val priceImportance: BigDecimal,
    val nowPrice: BigDecimal,
    val compareToYesterdaySign: String,
    val compareToYesterday: BigDecimal,
    val rateOfReturnPer: String,
)
