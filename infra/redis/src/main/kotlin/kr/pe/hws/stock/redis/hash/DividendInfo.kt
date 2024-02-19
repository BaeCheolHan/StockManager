package kr.pe.hws.stock.redis.hash

import kr.pe.hws.stock.constants.stock.StockDividendHistory
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.math.BigDecimal

@RedisHash
class DividendInfo(
    @Id
    val symbol: String,
    val annualDividend: BigDecimal = BigDecimal.ZERO,
    val dividendRate: BigDecimal = BigDecimal.ZERO,
    val dividendHistories: List<StockDividendHistory>,
)
