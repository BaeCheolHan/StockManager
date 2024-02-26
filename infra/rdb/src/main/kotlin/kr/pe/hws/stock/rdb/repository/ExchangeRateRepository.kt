package kr.pe.hws.stock.rdb.repository

import kr.pe.hws.stock.rdb.entity.ExchangeRateEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExchangeRateRepository : JpaRepository<ExchangeRateEntity, Long>
