package kr.pe.hws.stock.api.login.controller

import kr.pe.hws.stock.bank.account.BankAccount
import kr.pe.hws.stock.exchange.rate.ExchangeRate

interface LoginSpec {
    fun getRedirectUrl(snsType: String): Response.RedirectResponse
    fun getUserInfo(snsType: String, code: String, state: String?, scope: String?): Response.UserInfoResponse?

    object Response {
        data class RedirectResponse(
            val loginUri: String,
        )

        data class UserInfoResponse(
            val nickName: String,
            val profileImgUrl: String,
            val email: String,
            val memberId: String,
            val bankAccounts: Set<BankAccount>,
            val exchangeRate: ExchangeRate,
            val defaultBankAccountId: Long,
        )
    }
}
