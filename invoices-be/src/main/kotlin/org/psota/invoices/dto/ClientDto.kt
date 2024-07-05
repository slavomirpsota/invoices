package org.psota.invoices.dto

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ClientDto(
    var id: UUID?,
    @field:NotNull
    var address: AddressDto,
    @field:NotBlank
    var regNo: String,
    @field:NotBlank
    var taxNo: String,
    @field:NotBlank
    var vatNo: String
)