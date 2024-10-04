package kr.pe.hws.stock.redis.repository

import kr.pe.hws.stock.redis.hash.DividendInfo
import org.springframework.data.repository.CrudRepository

interface DividendInfoRepository : CrudRepository<DividendInfo, String>
