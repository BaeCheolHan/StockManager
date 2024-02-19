package kr.pe.hws.stock.constants.sns.kakao

data class KakaoUser(
    val id: String,
    val connected_at: String,
    val properties: KaKaoProperties,
    val kakao_account: KakaoAccount,
)
