package kr.pe.hws.stock.rdb.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import kr.pe.hws.stock.stocks.Stocks

@Entity
@Table(name = "stocks")
class StocksEntity(
    @Id
    val symbol: String,
    val code: String,
    val name: String,
    val national: String,
    val currency: String,
)

fun StocksEntity.toDomain() = Stocks(
    symbol = symbol,
    code = code,
    name = name,
    national = national,
    currency = currency,
)
