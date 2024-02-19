package kr.pe.hws.stock.api.endpoint.impl

import kr.pe.hws.stock.api.endpoint.LoginSpec
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class LoginController(
    @Value("\${spring.oauth.kakao.key}")
    val kakaoCode: String,
    @Value("\${spring.oauth.kakao.callback-url}")
    val kakaoCallbackUrl: String,
    @Value("\${spring.oauth.google.client_id}")
    val googleClientId: String,
    @Value("\${spring.oauth.google.callback-url}")
    val googleCallbackUrl: String,
    ) : LoginSpec {

    @GetMapping("/login/{snsType}")
    override fun getRedirectUrl(@PathVariable snsType: String): LoginSpec.Response.RedirectResponse {
        return LoginSpec.Response.RedirectResponse(
            loginUri = getRedirectUri(snsType),
        )
    }

    fun getRedirectUri(snsType: String): String {
        return when (snsType) {
            "kakao" -> String.format(
                "https://kauth.kakao.com/oauth/authorize?client_id=%s&redirect_uri=%s&response_type=code",
                kakaoCode,
                kakaoCallbackUrl,
            )
            "google" -> String.format(
                "https://accounts.google.com/o/oauth2/v2/auth?client_id=%s&scope=profile&response_type=code&redirect_uri=%s",
                googleClientId,
                googleCallbackUrl,
            )
            else -> throw RuntimeException("Invalid SNS Type")
        }

    }
}
