package kr.pe.hws.stock.api.login.controller.impl

import kr.pe.hws.stock.api.login.controller.LoginSpec
import kr.pe.hws.stock.api.login.service.LoginService
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(
    @Value("\${spring.oauth.kakao.key}")
    val kakaoClientId: String,
    @Value("\${spring.oauth.kakao.callback-url}")
    val kakaoCallbackUrl: String,
    @Value("\${spring.oauth.google.client_id}")
    val googleClientId: String,
    @Value("\${spring.oauth.google.callback-url}")
    val googleCallbackUrl: String,
    val loginService: LoginService,
) : LoginSpec {

    @GetMapping("/{snsType}")
    override fun getRedirectUrl(@PathVariable(required = true) snsType: String): LoginSpec.Response.RedirectResponse {
        return LoginSpec.Response.RedirectResponse(
            loginUri = getRedirectUri(snsType),
        )
    }

    @GetMapping("/oauth/{snsType}")
    override fun getUserInfo(
        @PathVariable(required = true) snsType: String,
        @RequestParam code: String,
        @RequestParam(required = false) state: String?,
        @RequestParam(required = false) scope: String?,
    ): LoginSpec.Response.UserInfoResponse {
        return loginService.login(snsType, code, state, scope)
    }

    fun getRedirectUri(@PathVariable snsType: String): String {
        return when (snsType) {
            "kakao" -> String.format(
                "https://kauth.kakao.com/oauth/authorize?client_id=%s&redirect_uri=%s&response_type=code",
                kakaoClientId,
                kakaoCallbackUrl,
            )

            "google" -> String.format(
                "https://accounts.google.com/o/oauth2/v2/auth?client_id=%s&scope=profile email" +
                    "&response_type=code&redirect_uri=%s",
                googleClientId,
                googleCallbackUrl,
            )

            else -> throw RuntimeException("Invalid SNS Type")
        }
    }
}
