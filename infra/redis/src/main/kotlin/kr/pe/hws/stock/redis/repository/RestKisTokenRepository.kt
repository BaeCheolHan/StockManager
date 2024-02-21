package kr.pe.hws.stock.redis.repository

import kr.pe.hws.stock.redis.hash.RestKisToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RestKisTokenRepository : CrudRepository<RestKisToken, String>
