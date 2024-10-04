package kr.pe.hws.stock.redis.hash

import kr.pe.hws.stock.api.kis.response.DailyIndexChartPriceWrapper
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.concurrent.TimeUnit

@RedisHash
class KrIndexChart(
    @Id
    val code: String,
    val data: DailyIndexChartPriceWrapper.KrDailyIndexChart,
) {
    @TimeToLive(unit = TimeUnit.MINUTES)
    val expiration: Long = 3
}