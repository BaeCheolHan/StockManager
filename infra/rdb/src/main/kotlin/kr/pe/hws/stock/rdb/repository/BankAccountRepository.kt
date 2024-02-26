package kr.pe.hws.stock.rdb.repository

import kr.pe.hws.stock.rdb.entity.BankAccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BankAccountRepository : JpaRepository<BankAccountEntity, String> {

    @Query("SELECT b FROM BankAccountEntity b JOIN FETCH b.stocks WHERE b.id = :id")
    fun findByIdJoinFetch(id: Long): Optional<BankAccountEntity>
}
