package kr.pe.hws.stock.rdb.repository

import kr.pe.hws.stock.rdb.entity.DepositWithdrawalHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepositWithdrawalHistoryRepository : JpaRepository<DepositWithdrawalHistoryEntity, Long>
