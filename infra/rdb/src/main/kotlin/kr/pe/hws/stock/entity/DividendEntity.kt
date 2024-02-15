package kr.pe.hws.stock.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "dividend")
class DividendEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val memberId: String,
    val year: Int,
    val month: Int,
    val day: Int,
    val symbol: String,
    @Column(nullable = false, precision = 24, scale = 6)
    val dividend: BigDecimal,
) : BaseTimeEntity() {
}
