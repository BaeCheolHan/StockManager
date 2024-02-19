package kr.pe.hws.stock.api.endpoint

interface LoginSpec {
    fun getRedirectUrl(snsType: String): Response.RedirectResponse

    object Response {
        data class RedirectResponse(
            val loginUri: String
        )
    }
}
