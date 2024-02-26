package kr.pe.hws.stock.rdb.entity

import jakarta.persistence.Column
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

@Entity
@Table(name = "deposit_withdrawal_history")
class DepositWithdrawalHistoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(nullable = false, precision = 24, scale = 6)
    val amount: BigDecimal,
    val memo: String,
) : BaseTimeEntity() {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    lateinit var bankAccount: BankAccountEntity
}
