package kr.pe.hws.stock.api.exchange.rate.service

import kr.pe.hws.stock.adapter.feign.client.ExchangeRateApi
import kr.pe.hws.stock.adapter.feign.client.ExchangeRateApiFeignClient
import kr.pe.hws.stock.exchange.rate.ExchangeRate
import kr.pe.hws.stock.rdb.entity.ExchangeRateEntity
import kr.pe.hws.stock.rdb.entity.toDomain
import kr.pe.hws.stock.rdb.repository.ExchangeRateRepository
import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class ExchangeRateService(
    val exchangeRateApiFeignClient: ExchangeRateApiFeignClient,
    val exchangeRateRepository: ExchangeRateRepository,
) {

    fun getExchangeRate(): ExchangeRate {
        val exchangeRateList: MutableList<ExchangeRateEntity> = exchangeRateRepository.findAll()
        if(exchangeRateList.isNotEmpty()) {
            return exchangeRateList.first().toDomain()
        } else {
             val list: List<ExchangeRate> = exchangeRateApiFeignClient.getExchangeRate(ExchangeRateApi.Reqeust("FRX.KRWUSD"))
            list.forEach(
                Consumer { exchangeRate: ExchangeRate ->
                    exchangeRateRepository.deleteById(exchangeRate.id)
                    exchangeRateRepository.save(ExchangeRateEntity(exchangeRate))
                },
            )
            return list.first()
        }
    }
}
