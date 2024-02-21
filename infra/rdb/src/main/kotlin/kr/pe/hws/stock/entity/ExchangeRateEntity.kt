package kr.pe.hws.stock.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import kr.pe.hws.stock.exchange.rate.ExchangeRate
import java.math.BigDecimal

@Entity
@Table(name = "exchange_rate")
class ExchangeRateEntity(
    @Id
    val id: Long,
    val code: String,
    val currencyCode: String,
    val currencyName: String,
    val country: String,
    val name: String,
    val date: String,
    val time: String,
    val recurrenceCount: Int,
    val basePrice: BigDecimal,
    val openingPrice: BigDecimal,
    val highPrice: BigDecimal,
    val lowPrice: BigDecimal,
    @Column(name = "\"change\"")
    val change: String,
    val changePrice: BigDecimal,
    val cashBuyingPrice: BigDecimal,
    val cashSellingPrice: BigDecimal,
    val ttBuyingPrice: BigDecimal,
    val ttSellingPrice: BigDecimal,
    val tcBuyingPrice: BigDecimal,
    val fcSellingPrice: BigDecimal,
    val exchangeCommission: BigDecimal,
    val usDollarRate: BigDecimal,
    val high52wPrice: BigDecimal,
    val high52wDate: String,
    val low52wPrice: BigDecimal,
    val low52wDate: String,
    val currencyUnit: Int,
    val provider: String,
    val timestamp: Long,
    val createdAt: String,
    val modifiedAt: String,
    val signedChangePrice: BigDecimal,
    val signedChangeRate: BigDecimal,
    val changeRate: BigDecimal,
)

fun ExchangeRateEntity.toDomain() = ExchangeRate(
    id = id,
    code = code,
    currencyCode = currencyCode,
    currencyName = currencyName,
    country = country,
    name = name,
    date = date,
    time = time,
    recurrenceCount = recurrenceCount,
    basePrice = basePrice,
    openingPrice = openingPrice,
    highPrice = highPrice,
    lowPrice = lowPrice,
    change = change,
    changePrice = changePrice,
    cashBuyingPrice = cashBuyingPrice,
    cashSellingPrice = cashSellingPrice,
    ttBuyingPrice = ttBuyingPrice,
    ttSellingPrice = ttSellingPrice,
    tcBuyingPrice = tcBuyingPrice,
    fcSellingPrice = fcSellingPrice,
    exchangeCommission = exchangeCommission,
    usDollarRate = usDollarRate,
    high52wPrice = high52wPrice,
    high52wDate = high52wDate,
    low52wPrice = low52wPrice,
    low52wDate = low52wDate,
    currencyUnit = currencyUnit,
    provider = provider,
    timestamp = timestamp,
    createdAt = createdAt,
    modifiedAt = modifiedAt,
    signedChangePrice = signedChangePrice,
    signedChangeRate = signedChangeRate,
    changeRate = changeRate,
)
