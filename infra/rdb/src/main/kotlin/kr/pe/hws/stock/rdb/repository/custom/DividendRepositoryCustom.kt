package kr.pe.hws.stock.rdb.repository.custom

import kr.pe.hws.stock.dividend.DividendInfo
import kr.pe.hws.stock.dividend.DividendInfoByItem
import kr.pe.hws.stock.dividend.DividendSumByMonth
import org.springframework.data.domain.Sort
import java.math.BigDecimal

interface DividendRepositoryCustom {
    fun findDividendChartByMemberId(memberId: String): List<DividendSumByMonth>
    fun findAllByMemberIdOrderByYearMonthDayAsc(memberId: String, sort: Sort): List<DividendInfo>

    fun findDividendInfoByMemberIdGroupBySymbol(memberId: String, basePrice: BigDecimal): List<DividendInfoByItem>
}
