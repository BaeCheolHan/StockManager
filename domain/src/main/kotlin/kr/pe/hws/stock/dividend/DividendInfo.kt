package kr.pe.hws.stock.dividend

import java.math.BigDecimal

data class DividendInfo (
    val id: Long,
    val year: Int,
    val month: Int,
    val day: Int,
    val symbol: String,
    val dividend: BigDecimal,
    val code: String,
    val name: String,
    val national: String,
)
