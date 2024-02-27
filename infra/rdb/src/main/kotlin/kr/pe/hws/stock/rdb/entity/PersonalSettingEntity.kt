package kr.pe.hws.stock.rdb.entity

import jakarta.persistence.ConstraintMode
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "personal_setting")
class PersonalSettingEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val defaultBankAccountId: Long,
) : BaseTimeEntity() {

    @OneToOne
    @JoinColumn(foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT), name = "member_id")
    lateinit var memberEntity: MemberEntity
}
