package kr.pe.hws.stock.rdb.repository

import kr.pe.hws.stock.rdb.entity.StockEntity
import kr.pe.hws.stock.rdb.repository.custom.StockRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StockRepository : JpaRepository<StockEntity, Long>, StockRepositoryCustom {
    fun findFirstBySymbol(symbol: String): Optional<StockEntity>

    fun deleteAllByBankAccountId(id: Long)
}
