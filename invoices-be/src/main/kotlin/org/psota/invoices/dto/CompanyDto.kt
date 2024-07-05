package org.psota.invoices.dto

import org.psota.invoices.entity.Invoice
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CompanyDto(
        var id: UUID?,
        @field:NotBlank
        var name: String,
        @field:NotNull
        var address: AddressDto,
        @field:NotBlank
        var regNo: String,
        @field:NotBlank
        var taxNo: String,
        @field:NotBlank
        var vatNo: String,
        @field:NotNull
        var bankInfo: BankInfoDto,
        var invoices: List<Invoice>?
)
