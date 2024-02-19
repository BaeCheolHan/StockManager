package kr.pe.hws.stock.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.Immutable
import org.hibernate.annotations.Subselect
import org.hibernate.annotations.Synchronize
import java.math.BigDecimal

@Entity
@Subselect(
    "SELECT @ROWNUM:=@ROWNUM+1 AS id, member_id, symbol, SUM(dividend) AS total_dividend " +
        "FROM dividend, (SELECT @ROWNUM:=0) AS R GROUP BY symbol, member_id")
@Immutable
@Synchronize("dividend")
class DividendSubSelect(
    @Id
    @GeneratedValue
    val id: Long,
    val memberId: String,
    val symbol: String,
    @Column(name = "total_dividend")
    val totalDividend: BigDecimal,
)
