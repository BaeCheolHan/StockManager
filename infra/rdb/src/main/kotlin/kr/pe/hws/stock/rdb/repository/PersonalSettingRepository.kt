package kr.pe.hws.stock.rdb.repository

import kr.pe.hws.stock.rdb.entity.PersonalSettingEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonalSettingRepository : JpaRepository<PersonalSettingEntity, String> {

    fun findByDefaultBankAccountId(id: Long): Optional<PersonalSettingEntity>
}
