package kr.pe.hws.stock.rdb.repository.custom

import kr.pe.hws.stock.stock.DashboardStock

interface StockRepositoryCustom {

    fun findAllDashboardStock(memberId: String?, bankId: Long?) : List<DashboardStock>
}
