package kr.pe.hws.stock.adapter

import kr.pe.hws.stock.api.sns.oauth2.request.TokenGetRequest
import kr.pe.hws.stock.api.sns.oauth2.response.SnsToken
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(
    name = "kakaoAuthApiFeignClient",
    url = "https://kauth.kakao.com",
    configuration = [StockManagerFeignClientConfig::class],
)
interface KakaoAuthApiFeignClient {
    @PostMapping("oauth/token")
    fun getToken(headers: HttpHeaders, @SpringQueryMap query: TokenGetRequest) : SnsToken.KakaoToken
}
