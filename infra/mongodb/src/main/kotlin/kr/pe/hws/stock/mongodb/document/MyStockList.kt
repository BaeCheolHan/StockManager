package kr.pe.hws.stock.mongodb.document

import kr.pe.hws.stock.constants.stock.DashboardStock
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class MyStockList(
    @Id
    val id : String,
    val data: List<DashboardStock>
)
