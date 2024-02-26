package kr.pe.hws.stock.redis.hash

import kr.pe.hws.stock.api.token.ApiToken
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive

@RedisHash
class RestKisToken(
    @Id
    val accessToken: String,
    val accessTokenTokenExpired: String,
    val tokenType: String,
    @TimeToLive
    val expiresIn: Int,
) {
    constructor(token: ApiToken.KisToken) : this(
        accessToken = token.accessToken,
        accessTokenTokenExpired = token.accessTokenTokenExpired,
        tokenType = token.tokenType,
        expiresIn = (token.expiresIn -10000)
    )
}
