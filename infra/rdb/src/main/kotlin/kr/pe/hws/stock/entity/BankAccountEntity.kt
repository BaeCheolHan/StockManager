package kr.pe.hws.stock.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.ConstraintMode
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import kr.pe.hws.stock.constants.Bank

@Entity
@Table(name = "bank_account")
class BankAccountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val memo: String,
    val alias: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val bank: Bank,
) : BaseTimeEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT), columnDefinition = "string", name = "member_id")
    lateinit var memberEntity: MemberEntity

    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    lateinit var stocks: List<StockEntity>

    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    lateinit var depositWithdrawalHistories: List<DepositWithdrawalHistoryEntity>

}
