package kr.pe.hws.stock.constants.sns.kakao

import java.time.LocalDateTime

data class KakaoAccount(
    val profile_needs_agreement: Boolean,
    val profile_nickname_needs_agreement: Boolean,
    val profile_image_needs_agreement: Boolean,
    val profile: KakaoProfile,
    val name_needs_agreement: Boolean,
    val name: String,
    val has_email: Boolean,
    val email_needs_agreement: Boolean,
    val is_email_valid: Boolean,
    val is_email_verified: Boolean,
    val email: String,
    val age_range_needs_agreement: Boolean,
    val age_range: String,
    val birthyear_needs_agreement: String,
    val birthyear: String,
    val birthday_needs_agreement: Boolean,
    val birthday: String,
    val birthday_type: String,
    val gender_needs_agreement: Boolean,
    val gender: String,
    val phone_number_needs_agreement: Boolean,
    val phone_number: String,
    val ci_needs_agreement: Boolean,
    val ci: String,
    val ci_authenticated_at: LocalDateTime,


    )
