package kr.pe.hws.stock.rdb.repository

import kr.pe.hws.stock.rdb.entity.DividendEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface DividendRepository :JpaRepository<DividendEntity, Long> {
    @Query(
        value = "SELECT year FROM dividend WHERE member_id = :memberId GROUP BY year ORDER BY year ASC",
        nativeQuery = true,
    )
    fun findYearByMemberIdGroupByYear(memberId: String?): List<Int?>?
}
