package kr.pe.hws.stock.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import kr.pe.hws.stock.constants.SnsType

@Entity
@Table(name = "member")
class MemberEntity(
    @Id
    val id: String,
    @Enumerated(EnumType.STRING)
    val snsType: SnsType,
    val email: String,
    val nickName: String,
    val password: String,
    val loginId: String,
) : BaseTimeEntity() {

    @OneToMany(
        mappedBy = "memberEntity",
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        targetEntity = BankAccountEntity::class,
    )
    lateinit var bankAccounts: Set<BankAccountEntity>

    @OneToOne(
        mappedBy = "memberEntity",
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
    )
    lateinit var personalSettings: PersonalSettingEntity

    @OneToMany(
        mappedBy = "memberEntity",
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        targetEntity = DailyTotalInvestmentAmountEntity::class,
    )
    lateinit var dailyTotalInvestmentAmounts: Set<DailyTotalInvestmentAmountEntity>
}
