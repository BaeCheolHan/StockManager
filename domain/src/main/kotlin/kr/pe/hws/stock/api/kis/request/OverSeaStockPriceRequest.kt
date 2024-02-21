package kr.pe.hws.stock.api.kis.request

data class OverSeaStockPriceRequest(
    val AUTH: String,
    val EXCD: String,
    val SYMB: String
)
