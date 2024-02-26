package kr.pe.hws.stock.rdb.repository

import kr.pe.hws.stock.rdb.entity.PersonalBankAccountSettingEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonalBankAccountSettingRepository : JpaRepository<PersonalBankAccountSettingEntity, String> {
    fun findByBankAccountId(bankAccountId: Long): Optional<PersonalBankAccountSettingEntity>
}
