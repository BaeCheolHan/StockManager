package kr.pe.hws.stock.dividend

import java.math.BigDecimal

data class DividendInfoByItem(
    val code: String,
    val name: String,
    val symbol: String,
    val national: String,
    val totalKrDividend: BigDecimal,
    val totalOverSeaDividend: BigDecimal,
)
