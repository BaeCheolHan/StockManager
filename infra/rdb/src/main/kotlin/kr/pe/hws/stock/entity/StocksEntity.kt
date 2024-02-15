package kr.pe.hws.stock.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "stocks")
class StocksEntity(
    @Id
    private var symbol: String,
    private var code: String,
    private var name: String,
    private var national: String,
    private var currency: String,
)
