package kr.pe.hws.stock.adapter

import kr.pe.hws.stock.constants.sns.kakao.KakaoUser
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    name = "kakaoApi",
    url = "https://kapi.kakao.com",
    configuration = [StockManagerFeignClientConfig::class],
)
interface KakoApiFeignClient {
    @PostMapping("/v2/user/me")
    fun getUserInfo(@RequestHeader headers: HttpHeaders) : KakaoUser
}
