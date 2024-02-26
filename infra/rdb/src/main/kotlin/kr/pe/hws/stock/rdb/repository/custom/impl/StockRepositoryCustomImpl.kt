package kr.pe.hws.stock.rdb.repository.custom.impl

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import kr.pe.hws.stock.rdb.entity.QBankAccountEntity
import kr.pe.hws.stock.rdb.entity.QDividendSubSelect
import kr.pe.hws.stock.rdb.entity.QStockEntity
import kr.pe.hws.stock.rdb.entity.QStocksEntity
import kr.pe.hws.stock.rdb.repository.custom.StockRepositoryCustom
import kr.pe.hws.stock.stock.DashboardStock
import java.math.BigDecimal

class StockRepositoryCustomImpl(private val queryFactory: JPAQueryFactory) : StockRepositoryCustom {

    override fun findAllDashboardStock(memberId: String?, bankId: Long?): List<DashboardStock> {
        val stock = QStockEntity.stockEntity
        val stocks = QStocksEntity.stocksEntity
        val bankAccount = QBankAccountEntity.bankAccountEntity
        val dividendSubSelect = QDividendSubSelect.dividendSubSelect

        val builder = BooleanBuilder()

        if (memberId != null) builder.and(bankAccount.memberEntity.id.eq(memberId))
        if (bankId != null) builder.and(bankAccount.id.eq(bankId))

        return queryFactory.from(stock)
            .select(
                Projections.fields(
                    DashboardStock::class.java,
                    stock.symbol,
                    stocks.code,
                    stocks.national,
                    stocks.name,
                    stock.price.multiply(stock.quantity).sum().divide(stock.quantity.sum()).`as`("avgPrice"),
                    stock.quantity.sum().`as`("quantity"),
                    dividendSubSelect.totalDividend.coalesce(BigDecimal.ZERO).`as`("totalDividend"),
                ),
            )
            .innerJoin(stocks).on(stock.symbol.eq(stocks.symbol))
            .innerJoin(bankAccount).on(stock.bankAccount.id.eq(bankAccount.id))
            .leftJoin(dividendSubSelect)
            .on(
                stock.symbol.eq(dividendSubSelect.symbol)
                    .and(bankAccount.memberEntity.id.eq(dividendSubSelect.memberId)),
            )
            .where(builder)
            .orderBy(stock.quantity.asc())
            .groupBy(stock.symbol)
            .fetch()
    }
}
