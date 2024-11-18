package kr.pe.hws.stock.redis.repository

import kr.pe.hws.stock.redis.hash.KrIndexChart
import org.springframework.data.repository.CrudRepository

interface KrIndexChartRepository : CrudRepository<KrIndexChart, String>
