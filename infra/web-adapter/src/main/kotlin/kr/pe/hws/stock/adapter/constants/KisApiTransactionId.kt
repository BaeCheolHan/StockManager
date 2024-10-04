package kr.pe.hws.stock.adapter.constants

enum class KisApiTransactionId(val transactionId: String) {
    OVER_SEA_INDEX_CHART_PRICE ("FHKST03030100"),
    KR_INDEX_CHART_PRICE ("FHKUP03500100");

    val TRANSACTION_ID: String
        get() = transactionId
}
