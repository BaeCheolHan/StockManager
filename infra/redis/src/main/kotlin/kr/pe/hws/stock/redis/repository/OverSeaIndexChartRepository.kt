package kr.pe.hws.stock.redis.repository

import kr.pe.hws.stock.redis.hash.KrIndexChart
import kr.pe.hws.stock.redis.hash.OverSeaIndexChart
import org.springframework.data.repository.CrudRepository

interface OverSeaIndexChartRepository : CrudRepository<OverSeaIndexChart, String>
