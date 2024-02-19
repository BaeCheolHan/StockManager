package kr.pe.hws.stock.constants.feign.kis.request

data class OverSeaStockPriceRequest(
    val AUTH: String,
    val EXCD: String,
    val SYMB: String
)
