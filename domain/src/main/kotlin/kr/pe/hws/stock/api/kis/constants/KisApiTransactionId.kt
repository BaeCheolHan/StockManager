package kr.pe.hws.stock.api.kis.constants

enum class KisApiTransactionId(private val transactionId: String) {
    KR_INDEX_CHART_PRICE("FHKUP03500100"),
    OVER_SEA_INDEX_CHART_PRICE("FHKST03030100");

    override fun toString(): String {
        return transactionId
    }

    fun getId(): String = transactionId
}
