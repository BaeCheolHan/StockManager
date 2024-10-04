package kr.pe.hws.stock.dividend

import java.math.BigDecimal

data class DividendSumByMonth(
    val year: Int,
    val month: Int,
    val dividend: BigDecimal,
)
