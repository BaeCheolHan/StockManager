package kr.pe.hws.stock.api.kis.request

object KisApiRequest {

    data class KisTokenGenerateRequest(
        val grant_type: String,
        val appkey: String,
        val appsecret: String,
    ) {
        constructor(appKey: String, appSecret: String) : this("client_credentials", appKey, appSecret)
    }

    data class KrStockPriceRequest(
        val fid_cond_mrkt_div_code: String,
        val fid_input_iscd: String,
    )

    data class OverSeaStockPriceRequest(
        val AUTH: String,
        val EXCD: String,
        val SYMB: String
    )
}
