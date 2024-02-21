package kr.pe.hws.stock.bank

data class BankEnumMapperValue(
    val code: String,
    val bankCode: String,
    val bankName: String,
) {
    constructor() : this("", "", "")
    constructor(bankType: BankEnumMapperType) : this(bankType.getCode(), bankType.getBankCode(), bankType.getBankName())
}
