package kr.pe.hws.stock.api.kis.output

import java.math.BigDecimal

data class OverSeaNowStockPriceOutput(
    // 실시간조회종목코드
    // D+시장구분(3자리)+종목코드
    // 예) DNASAAPL : D+NAS(나스닥)+AAPL(애플)
    // [시장구분]
    // NYS : 뉴욕, NAS : 나스닥, AMS : 아멕스 ,
    // TSE : 도쿄, HKS : 홍콩,
    // SHS : 상해, SZS : 심천
    // HSX : 호치민, HNX : 하노이
    val symbol: String,
    val rsym: String,

    // 소수점자리수
    val zdiv: Int,

    // 통화
    val curr: String,

    // 매매단위
    val vnit: BigDecimal,

    // 시가(해당일 최초 거래가격)
    val open: BigDecimal,

    // 고가(해당일 가장 높은 거래가격)
    val high: BigDecimal,

    // 저가(해당일 가장 낮은 거래가격)
    val low: BigDecimal,

    // 현재가
    val last: BigDecimal,

    // 전일종가
    val base: BigDecimal,

    // 전일 거래량
    val pvol: Long,

    // 전일거래대금
    val pamt: BigDecimal,

    // 상한가
    val uplp: BigDecimal,

    // 하한가
    val dnlp: BigDecimal,

    // 52주최고가
    val h52p: BigDecimal,

    // 52주최고일자
    val h52d: String,

    // 52주최저가
    val l52p: BigDecimal,

    // 52주최저일자
    val l52d: String,

    // per
    val perx: BigDecimal,

    // pbr
    val pbrx: BigDecimal,

    // eps
    val epsx: BigDecimal,

    // BPS
    val bpsx: BigDecimal,

    // 상장주수
    val shar: Long,

    // 자본금
    val mcap: BigDecimal,

    // 시가총액
    val tomv: BigDecimal,

    // 원환산당일가격
    val t_xprc: BigDecimal,

    // 원환산당일대비
    val t_xdif: BigDecimal,

    // 원환산당일등락
    val t_xrat: BigDecimal,

    // 원환산전일가격
    val p_xprc: BigDecimal,

    // 원환산전일대비
    val p_xdif: BigDecimal,

    // 원환산전일등락
    val p_xrat: BigDecimal,

    // 당일환율
    val t_rate: BigDecimal,

    // 전일환율
    val p_rate: BigDecimal,

    // 원환산당일기호
    val t_xsgn: String,

    // 원환산전일기호
    val p_xsng: String,

    // 거래가능여부
    val e_ordyn: String,

    // 호가단위
    val e_hogau: BigDecimal,

    // 업종(섹터)
    val e_icod: String,

    // 액면가
    val e_parp: BigDecimal,

    // 거래량
    val tvol: BigDecimal,

    // 거래대금
    val tamt: BigDecimal,

    // ETP 분류명
    val etyp_nm: BigDecimal,
)
