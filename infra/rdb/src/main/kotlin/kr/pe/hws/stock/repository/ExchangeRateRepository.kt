package kr.pe.hws.stock.repository

import kr.pe.hws.stock.entity.ExchangeRateEntity
import kr.pe.hws.stock.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ExchangeRateRepository : JpaRepository<ExchangeRateEntity, Long> {
}
