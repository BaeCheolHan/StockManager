package kr.pe.hws.stock.redis.hash

import kr.pe.hws.stock.api.token.ApiToken
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive

@RedisHash("RestKisToken")
class RestKisToken(
    @Id
    val access_token: String,
    val access_token_token_expired: String,
    val token_type: String,
    @TimeToLive
    val expires_in: Int,
) {
    constructor(token: ApiToken.KisToken) : this(
        access_token = token.accessToken,
        access_token_token_expired = token.accessTokenTokenExpired,
        token_type = token.tokenType,
        expires_in = (token.expiresIn - 10000),
    )
}
