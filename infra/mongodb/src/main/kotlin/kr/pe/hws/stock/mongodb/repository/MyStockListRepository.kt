package kr.pe.hws.stock.mongodb.repository

import kr.pe.hws.stock.mongodb.document.MyStockList
import org.springframework.data.mongodb.repository.MongoRepository

interface MyStockListRepository : MongoRepository<MyStockList, String>
