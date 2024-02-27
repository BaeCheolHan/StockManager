package kr.pe.hws.stock.api.sns.user.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import kr.pe.hws.stock.constants.SnsType
import java.time.LocalDateTime

object User {

    data class SnsUser(
        val id: String,
        val snsType: SnsType,
        val name: String,
        val email: String,
    )

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class KakaoUser(
        val id: String,
        val connectedAt: String,
        val properties: KaKaoProperties,
        val kakaoAccount: KakaoAccount,
        val snsType: SnsType = SnsType.KAKAO,
    )

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class KakaoAccount(
        val profileNeedsAgreement: Boolean,
        val profileNicknameNeedsAgreement: Boolean,
        val profileImageNeedsAgreement: Boolean,
        val profile: KakaoProfile,
        val nameNeedsAgreement: Boolean,
        val name: String?,
        val hasEmail: Boolean,
        val emailNeedsAgreement: Boolean,
        val isEmailValid: Boolean,
        val isEmailVerified: Boolean,
        val email: String,
        val ageRangeNeedsAgreement: Boolean,
        val ageRange: String?,
        val birthyearNeedsAgreement: String?,
        val birthyear: String?,
        val birthdayNeedsAgreement: Boolean?,
        val birthday: String?,
        val birthdayType: String?,
        val genderNeedsAgreement: Boolean?,
        val gender: String?,
        val phoneNumberNeedsAgreement: Boolean?,
        val phoneNumber: String?,
        val ciNeedsAgreement: Boolean?,
        val ci: String?,
        val ciAuthenticatedAt: LocalDateTime?,
    )

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class KakaoProfile(
        val nickname: String,
        val thumbnailImageUrl: String,
        val profileImageUrl: String,
        val isDefaultImage: Boolean,
    )

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class KaKaoProperties(
        val nickname: String,
        val thumbnailImageUrl: String?,
        val profileImageUrl: String?,
        val isDefaultImage: Boolean,
    )

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class GoogleUser(
        val id: String,
        val name: String,
        val givenName: String,
        val familyName: String,
        val picture: String,
        val email: String,
        val emailVerified: Boolean,
        val locale: String,
        val snsType: SnsType = SnsType.GOOGLE,
    )

    fun KakaoUser.toSnsUser() = SnsUser(
        id = id,
        snsType = snsType,
        name = kakaoAccount.profile.nickname,
        email = kakaoAccount.email,
    )

    fun GoogleUser.toSnsUser() = SnsUser(
        id = id,
        snsType = snsType,
        name = name,
        email = email,
    )
}
