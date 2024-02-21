package kr.pe.hws.stock.adapter.feign.client

import kr.pe.hws.stock.adapter.feign.config.StockManagerFeignClientConfig
import kr.pe.hws.stock.api.sns.oauth2.request.TokenGetRequest
import kr.pe.hws.stock.api.token.ApiToken
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(
    name = "googleAuthApiFeignClient",
    url = "https://oauth2.googleapis.com",
    configuration = [StockManagerFeignClientConfig::class],
)
interface GoogleAuthApiFeignClient {
    @PostMapping("/token")
    fun getToken(headers: HttpHeaders, @SpringQueryMap query: TokenGetRequest) : ApiToken.GoogleToken
}
