package kr.pe.hws.stock.rdb.entity

import jakarta.persistence.ConstraintMode
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import kr.pe.hws.stock.personal.PersonalBankAccountSetting

@Entity
@Table(name = "personal_bank_account_setting")
class PersonalBankAccountSettingEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val defaultNational: String,
    val defaultCode: String,
) : BaseTimeEntity() {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT), name = "bank_account_id")
    lateinit var bankAccount: BankAccountEntity
}

fun PersonalBankAccountSettingEntity.toDomain() = PersonalBankAccountSetting(
    id = id,
    defaultNational = defaultNational,
    defaultCode = defaultCode,
)
