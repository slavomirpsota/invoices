package org.psota.invoices.dto

import javax.validation.constraints.NotBlank

data class BankInfoDto(
        @field:NotBlank
        var accountNo: String,
        @field:NotBlank
        var iban: String,
        @field:NotBlank
        var bankName: String,
        @field:NotBlank
        var swiftCode: String,
        @field:NotBlank
        var paymentMethod: String,
)
