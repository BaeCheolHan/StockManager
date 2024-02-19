package kr.pe.hws.stock.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
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
) : BaseTimeEntity()
