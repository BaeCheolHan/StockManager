package kr.pe.hws.stock.rdb.repository

import kr.pe.hws.stock.rdb.entity.DailyTotalInvestmentAmountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DailyTotalInvestmentAmountRepository : JpaRepository<DailyTotalInvestmentAmountEntity, Long>
