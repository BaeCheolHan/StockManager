package kr.pe.hws.stock.rdb.repository

import kr.pe.hws.stock.rdb.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MemberRepository : JpaRepository<MemberEntity, String> {
    fun findByEmail(email: String) : Optional<MemberEntity>
    fun findByNickName(nickName: String) : Optional<MemberEntity>
}
