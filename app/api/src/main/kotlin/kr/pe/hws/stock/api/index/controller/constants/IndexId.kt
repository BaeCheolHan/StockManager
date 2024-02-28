package kr.pe.hws.stock.api.index.controller.constants

enum class IndexId (val id: String, val code: String){
    KOSPI("KOSPI", "0001"),
    KOSDAQ("KOSDAQ", "1001"),
    SNP500("SNP500", "SPX"),
    NASDAQ("NASDAQ", "COMP"),
    DAW("DAW", ".DJI"),
    PHILADELPHIA("PHILADELPHIA", "SOX");
}
