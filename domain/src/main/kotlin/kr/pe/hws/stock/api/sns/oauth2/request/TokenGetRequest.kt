package kr.pe.hws.stock.api.sns.oauth2.request

data class TokenGetRequest(
    val grant_type: String,
    val client_id: String,
    val client_secret: String?,
    val redirect_uri: String,
    val code: String,
)
