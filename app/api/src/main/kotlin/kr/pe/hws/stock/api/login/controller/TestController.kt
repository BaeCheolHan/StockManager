package kr.pe.hws.stock.api.login.controller

import kr.pe.hws.stock.adapter.feign.client.KisApiFeignClient
import kr.pe.hws.stock.api.kis.request.KisApiRequest
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.String

@RestController
@RequestMapping("/test")
class TestController(
    val kisApiFeignClient: KisApiFeignClient,
) {
    @GetMapping
    fun test() {
        val headers = HttpHeaders()
        headers.add("authorization", String.format("%s %s", "Bearer", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b2tlbiIsImF1ZCI6IjIwYWQ3OTk5LTM3MTUtNDBjMS05ODlmLWQ1MGFiMWRkODI5YSIsImlzcyI6InVub2d3IiwiZXhwIjoxNzA4NTQ0NDAxLCJpYXQiOjE3MDg0NTgwMDEsImp0aSI6IlBTenhzYXIyTm5EUDd5VEJqa0JFT3pSZGhUdDVIQ3FMbFdyUyJ9.dTFbYlIzCg2huzVM57VECR8W5cFQaZpr3QWxzhayATfNff5zNnAI8YZRshQ_XOaK7_sMf2f7tSHFh6TkQ6PyrQ"))
        headers.add("content-type", "application/json; charset=utf-8")
        headers.add("appkey", "PSzxsar2NnDP7yTBjkBEOzRdhTt5HCqLlWrS")
        headers.add("appsecret", "ADqlI3LL2K8e41zr8qiTPZ8coEFQSgglOOX3CAXARl2p5QV2/cB+0xjQXq5imMvWs+TvzI1Zu7jdAsL83Cm1ck0vnRlvAMxrwMVLSFckZ0JE9k+ROR80hukHtm2ZA7GzTo25DGSdDX93+5L9L82Y/10xtXUfzLjSdkl0A2qKvwz4kIw0+i4=")
        headers.add("custtype", "P")
        headers.add("tr_id", "HHDFS76200200")
        val resp = kisApiFeignClient.getOverSeaStockPrice(headers, KisApiRequest.OverSeaStockPriceRequest("", "NYS", "O"))

        println(resp)
    }
}
