package org.psota.invoices.dto

import org.psota.invoices.entity.Invoice

class CompanyDto {
    val name: String? = null
    val address: AddressDto? = null
    val regNo: String? = null
    val taxNo: String? = null
    val vatNo: String? = null
    val bankInfo: BankInfoDto? = null
    val invoices: List<Invoice>? = null
}
