package kr.pe.hws.stock.rdb.repository.custom.impl

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import kr.pe.hws.stock.dividend.DividendInfo
import kr.pe.hws.stock.dividend.DividendInfoByItem
import kr.pe.hws.stock.dividend.DividendSumByMonth
import kr.pe.hws.stock.rdb.entity.QDividendEntity
import kr.pe.hws.stock.rdb.entity.QExchangeRateEntity
import kr.pe.hws.stock.rdb.entity.QStocksEntity
import kr.pe.hws.stock.rdb.repository.custom.DividendRepositoryCustom
import org.springframework.data.domain.Sort
import java.math.BigDecimal

class DividendRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory,
) : DividendRepositoryCustom {

    override fun findDividendChartByMemberId(memberId: String): List<DividendSumByMonth> {

        val dividend = QDividendEntity.dividendEntity
        val stocks = QStocksEntity.stocksEntity
        val exchangeRate = QExchangeRateEntity.exchangeRateEntity

        return queryFactory.from(dividend)
            .select(
                Projections.fields(
                    DividendSumByMonth::class.java, dividend.year, dividend.month,
                    stocks.national
                        .`when`("KR").then(dividend.dividend)
                        .otherwise(dividend.dividend.multiply(exchangeRate.basePrice)).sum().`as`("dividend"),
                ),
            )
            .innerJoin(stocks).on(dividend.symbol.eq(stocks.symbol))
            .join(exchangeRate)
            .where(dividend.memberId.eq(memberId))
            .groupBy(dividend.year, dividend.month)
            .orderBy(dividend.year.asc(), dividend.month.asc())
            .fetch()
    }

    override fun findAllByMemberIdOrderByYearMonthDayAsc(memberId: String, sort: Sort): List<DividendInfo> {
        val dividend = QDividendEntity.dividendEntity
        val stocks = QStocksEntity.stocksEntity

        return queryFactory.from(dividend)
            .select(
                Projections.fields(
                    DividendInfo::class.java, dividend.id, dividend.year, dividend.month, dividend.day,
                    dividend.symbol, dividend.dividend, stocks.code, stocks.name, stocks.national,
                ),
            )
            .innerJoin(stocks).on(dividend.symbol.eq(stocks.symbol))
            .where(dividend.memberId.eq(memberId))
            .fetch()

        /**
         *  order by sort 로직 추가 필요
         * 	.orderBy(sorts.stream()
         * 			.map(sort -> new OrderSpecifier(sort.isAscending() ? Order.ASC : Order.DESC, new PathBuilder(Dividend.class, sort.getProperty())))
         * 			.toArray(OrderSpecifier[]::new))
         */

    }

    override fun findDividendInfoByMemberIdGroupBySymbol(
        memberId: String,
        basePrice: BigDecimal,
    ): List<DividendInfoByItem> {
        val dividend = QDividendEntity.dividendEntity
        val stocks = QStocksEntity.stocksEntity

        return queryFactory.from(dividend)
            .select(
                Projections.fields(
                    DividendInfoByItem::class.java, stocks.code, stocks.name, dividend.symbol, stocks.national,
                    stocks.national
                        .`when`("KR")
                        .then(dividend.dividend.sum())
                        .otherwise(dividend.dividend.sum().multiply(basePrice)).`as`("totalKrDividend"),
                    stocks.national
                        .`when`("KR")
                        .then(BigDecimal.ZERO)
                        .otherwise(dividend.dividend.sum())
                        .`as`("totalOverSeaDividend"),
                ),
            )
            .innerJoin(stocks).on(dividend.symbol.eq(stocks.symbol))
            .where(dividend.memberId.eq(memberId))
            .groupBy(dividend.symbol)
            .fetch()
    }
}
