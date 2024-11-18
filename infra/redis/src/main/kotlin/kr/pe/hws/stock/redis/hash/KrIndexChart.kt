package kr.pe.hws.stock.redis.hash

import kr.pe.hws.stock.api.kis.response.DailyIndexChartPriceWrapper
import kr.pe.hws.stock.stock.StockDividendHistory
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.math.BigDecimal

@RedisHash
class KrIndexChart(
    @Id
    val code: String,
    val data: DailyIndexChartPriceWrapper.KrDailyIndexChart,
)
