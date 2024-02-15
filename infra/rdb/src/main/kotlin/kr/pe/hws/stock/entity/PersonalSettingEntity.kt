package kr.pe.hws.stock.entity

import jakarta.persistence.*

@Entity
@Table(name = "personal_setting")
class PersonalSettingEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val defaultBankAccountId: Long

): BaseTimeEntity() {
    @OneToOne
    @JoinColumn(foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    lateinit var memberEntity: MemberEntity
}
