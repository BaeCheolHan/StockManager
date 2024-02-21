package kr.pe.hws.stock.api.kis.response

import kr.pe.hws.stock.api.kis.output.OverSeaNowStockPriceOutput

data class OverSeaNowStockPriceWrapper(
    val rt_code: String,
    val msg_cd: String,
    val msg1: String,
    val output : OverSeaNowStockPriceOutput
)
