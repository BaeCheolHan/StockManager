package kr.pe.hws.stock.entity

import jakarta.persistence.*
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
    val bank: Bank,
) : BaseTimeEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT), columnDefinition = "string", name = "member_id")
    lateinit var memberEntity: MemberEntity
}
