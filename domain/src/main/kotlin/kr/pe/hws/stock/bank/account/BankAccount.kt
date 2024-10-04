package kr.pe.hws.stock.bank.account

import kr.pe.hws.stock.bank.BankEnumMapperValue
import kr.pe.hws.stock.constants.Bank
import kr.pe.hws.stock.personal.PersonalBankAccountSetting

data class BankAccount(
    val id: Long,
    val memo: String?,
    val alias: String?,
    val bank: Bank,
    val bankInfo: BankEnumMapperValue,
    val personalBankAccountSetting: PersonalBankAccountSetting,
)
