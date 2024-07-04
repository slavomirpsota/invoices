package org.psota.invoices.dto

import javax.validation.constraints.NotBlank

data class AddressDto(
        @field:NotBlank
        val street: String,
        @field:NotBlank
        val streetNo: String,
        @field:NotBlank
        val city: String,
        @field:NotBlank
        val zipCode: String,
)