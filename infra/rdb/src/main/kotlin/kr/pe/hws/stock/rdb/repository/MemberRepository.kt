package kr.pe.hws.stock.rdb.repository

import kr.pe.hws.stock.rdb.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MemberRepository : JpaRepository<MemberEntity, String> {
    fun findByEmail(email: String): Optional<MemberEntity>
    fun findByNickName(nickName: String): Optional<MemberEntity>

    @Query(
        "SELECT m FROM MemberEntity m " +
            "LEFT JOIN BankAccountEntity b ON m.id = b.memberEntity.id JOIN FETCH m.bankAccounts " +
            "LEFT JOIN PersonalSettingEntity p ON m.id = p.memberEntity.id JOIN FETCH m.personalSettings " +
            "WHERE m.id = :id",
    )
    fun findByIdJoinFetch(id: String): Optional<MemberEntity>
}
