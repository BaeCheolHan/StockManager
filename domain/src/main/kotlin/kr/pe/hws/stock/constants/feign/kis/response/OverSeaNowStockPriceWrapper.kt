package kr.pe.hws.stock.constants.feign.kis.response

import kr.pe.hws.stock.redis.hash.OverSeaNowStockPrice

data class OverSeaNowStockPriceWrapper(
    val rt_code: String,
    val msg_cd: String,
    val msg1: String,
    val output : OverSeaNowStockPrice
)
