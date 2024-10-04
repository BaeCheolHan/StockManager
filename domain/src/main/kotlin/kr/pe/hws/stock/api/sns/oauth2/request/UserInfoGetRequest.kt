package kr.pe.hws.stock.api.sns.oauth2.request

object UserInfoGetRequest {

    data class Google(
        val access_token: String,
    )
}
