package kr.pe.hws.stock.adapter.feign.client

import kr.pe.hws.stock.adapter.feign.config.StockManagerFeignClientConfig
import kr.pe.hws.stock.api.sns.oauth2.request.UserInfoGetRequest
import kr.pe.hws.stock.api.sns.user.response.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    name = "googleApiFeignClientFeignClient",
    url = "https://www.googleapis.com",
    configuration = [StockManagerFeignClientConfig::class],
)
interface GoogleApiFeignClient {
    @GetMapping("/oauth2/v3/userinfo")
    fun getUserInfo(
        @RequestHeader headers: HttpHeaders,
        @SpringQueryMap param: UserInfoGetRequest.Google,
    ): User.GoogleUser

}
