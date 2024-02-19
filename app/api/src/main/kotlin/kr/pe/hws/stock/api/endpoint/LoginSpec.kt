package kr.pe.hws.stock.api.endpoint

import org.springframework.web.bind.annotation.PathVariable

interface LoginSpec {
    fun getRedirectUrl(snsType: String): Response.RedirectResponse

    object Response {
        data class RedirectResponse(
            val loginUri: String
        )
    }
}
