package kr.pe.hws.stock.constants.feign.kis.response

import kr.pe.hws.stock.constants.feign.kis.output.OverSeaNowStockPriceOutput

data class OverSeaNowStockPriceWrapper(
    val rt_code: String,
    val msg_cd: String,
    val msg1: String,
    val output : OverSeaNowStockPriceOutput
)
