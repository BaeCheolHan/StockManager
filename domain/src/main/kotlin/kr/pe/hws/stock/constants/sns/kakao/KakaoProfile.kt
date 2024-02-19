package kr.pe.hws.stock.constants.sns.kakao

data class KakaoProfile(
    val nickname: String,
    val thumbnail_image_url: String,
    val profile_image_url: String,
    val is_default_image: Boolean,
)
