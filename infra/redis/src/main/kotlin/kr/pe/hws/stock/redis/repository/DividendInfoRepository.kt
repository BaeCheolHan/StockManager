package kr.pe.hws.stock.redis.repository

import kr.pe.hws.stock.redis.hash.DividendInfo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DividendInfoRepository : CrudRepository<DividendInfo, String>
