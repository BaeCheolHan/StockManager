package kr.pe.hws.stock.entity

import jakarta.persistence.*
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
    @JoinColumn(foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT), columnDefinition = "string", name = "member_id")
    lateinit var memberEntity: MemberEntity
}
