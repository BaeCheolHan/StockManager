package kr.pe.hws.stock.rdb.repository

import kr.pe.hws.stock.rdb.entity.StocksEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StocksRepository : JpaRepository<StocksEntity, String> {

    @Query(value = "SELECT code FROM stocks WHERE national = :national GROUP BY code", nativeQuery = true)
    fun findCodeByNationalGroupByCode(@Param("national") national: String): List<String>

    fun findAllByCode(code: String): List<StocksEntity>

    fun findBySymbol(symbol: String): Optional<StocksEntity>
}
