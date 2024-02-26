package kr.pe.hws.stock.adapter.util

import kr.pe.hws.stock.adapter.feign.client.KisApiFeignClient
import kr.pe.hws.stock.adapter.feign.client.KisApiRequest
import kr.pe.hws.stock.redis.hash.RestKisToken
import kr.pe.hws.stock.redis.repository.RestKisTokenRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class KisApiTokenProvider(
    @Value("\${spring.api.kis.appKey}")
    var appKey: String,
    @Value("\${spring.api.kis.app-secret}")
    val appSecret: String,
    val restKisTokenRepository: RestKisTokenRepository,
    val kisApiFeignClient: KisApiFeignClient,
) {

    fun getRestKisToken(): RestKisToken {
        val tokens: MutableIterable<RestKisToken> = restKisTokenRepository.findAll()
        println(tokens)

        val l = tokens.toList().stream().filter(Objects::nonNull).toList()

        if (l.isNotEmpty()) {
            return l.first()
        } else {
            val response = kisApiFeignClient.getKisApiToken(
                KisApiRequest.KisTokenGenerateRequest(
                    appKey,
                    appSecret,
                ),
            )

            val token = RestKisToken(response)
            restKisTokenRepository.save(token)
            return token
        }

    }
}
