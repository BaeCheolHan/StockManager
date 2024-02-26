package kr.pe.hws.stock.redis.repository

import kr.pe.hws.stock.redis.hash.RestKisToken
import org.springframework.data.repository.CrudRepository

interface RestKisTokenRepository : CrudRepository<RestKisToken, String>
