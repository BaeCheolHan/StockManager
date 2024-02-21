package kr.pe.hws.stock.api.sns.oauth2.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

object SnsToken {

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class KakaoToken(
        val accessToken: String,
        val tokenType: String,
        val refreshToken: String,
        val idToken: String,
        val expiresIn: Int,
        val scope: String,
        val refreshTokenExpiresIn: String,
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class GoogleToken(
        val accessToken: String,
        val scope: String,
        val tokenType: String,
        val idToken: String
    )


}
