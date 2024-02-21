package kr.pe.hws.stock.api.login.service

import kr.pe.hws.stock.adapter.GoogleApiFeignClient
import kr.pe.hws.stock.adapter.GoogleAuthApiFeignClient
import kr.pe.hws.stock.adapter.KakaoAuthApiFeignClient
import kr.pe.hws.stock.adapter.KakoApiFeignClient
import kr.pe.hws.stock.api.sns.oauth2.request.TokenGetRequest
import kr.pe.hws.stock.api.sns.oauth2.request.UserInfoGetRequest
import kr.pe.hws.stock.api.sns.user.response.User
import kr.pe.hws.stock.api.sns.user.response.User.toSnsUser
import kr.pe.hws.stock.entity.MemberEntity
import kr.pe.hws.stock.repository.MemberRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service

@Service
class LoginService(
    @Value("\${spring.oauth.kakao.key}")
    val kakaoClientId: String,
    @Value("\${spring.oauth.kakao.callback-url}")
    val kakaoCallbackUrl: String,
    @Value("\${spring.oauth.google.client_id}")
    val googleClientId: String,
    @Value("\${spring.oauth.google.client_secret}")
    val googleClientSecrit: String,

    @Value("\${spring.oauth.google.callback-url}")
    val googleCallbackUrl: String,
    val kakaoAuthApiFeignClient: KakaoAuthApiFeignClient,
    val kakaoApiFeignClient: KakoApiFeignClient,
    val googleAuthApiFeignClient: GoogleAuthApiFeignClient,
    val googleApiFeignClient: GoogleApiFeignClient,
    val memberRepository: MemberRepository,
) {
    //    : LoginSpec.Response.UserInfoResponse
    fun login(snsType: String, code: String, state: String?, scope: String?) {
        when (snsType) {
            "kakao" -> {
                val query = TokenGetRequest("authorization_code", kakaoClientId, null, kakaoCallbackUrl, code)
                val headers = HttpHeaders()
                headers.contentType = MediaType.APPLICATION_FORM_URLENCODED

                val token = kakaoAuthApiFeignClient.getToken(headers, query)

                headers.setBearerAuth(token.accessToken)
                val user = kakaoApiFeignClient.getUserInfo(headers)

                val member = findMember(user.toSnsUser())


            }

            "google" -> {
                val query =
                    TokenGetRequest("authorization_code", googleClientId, googleClientSecrit, googleCallbackUrl, code)
                val headers = HttpHeaders()
                headers.contentType = MediaType.APPLICATION_FORM_URLENCODED
                val googleToken = googleAuthApiFeignClient.getToken(headers, query)
                val user = googleApiFeignClient.getUserInfo(headers, UserInfoGetRequest.Google(
                    access_token = googleToken.accessToken
                ))

                val member = findMember(user.toSnsUser())
            }
        }


    }

    fun findMember(user: User.SnsUser): MemberEntity {
        return memberRepository.findById(user.id).orElseGet {
            memberRepository.save(
                MemberEntity(
                    id = user.id,
                    snsType = user.snsType,
                    nickName = user.name,
                    email = user.email,
                    loginId = user.id,
                ),
            )
        }
    }
}
