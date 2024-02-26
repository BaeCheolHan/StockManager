package kr.pe.hws.stock.rdb.entity

import jakarta.persistence.ConstraintMode
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "daily_total_investment_amount")
class DailyTotalInvestmentAmountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val date: LocalDateTime,
    val totalInvestmentAmount: BigDecimal,
    val evaluationAmount: BigDecimal,
) : BaseTimeEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT), name = "member_id")
    lateinit var memberEntity: MemberEntity
}
