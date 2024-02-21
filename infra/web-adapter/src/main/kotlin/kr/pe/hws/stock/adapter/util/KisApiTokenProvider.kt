package kr.pe.hws.stock.adapter.util

import kr.pe.hws.stock.redis.repository.RestKisTokenRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class KisApiTokenProvider(
    @Value("\${spring.api.kis.appKey}")
    var appKey: String,
    @Value("\${spring.api.kis.app-secret}")
    val appSecret: String,
    val restKisTokenRepository: RestKisTokenRepository
) {

    fun getRestKisToken() {

    }
}
