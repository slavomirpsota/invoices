package org.psota.invoices

import org.psota.invoices.dto.AddressDto
import org.psota.invoices.dto.BankInfoDto
import org.psota.invoices.dto.CompanyDto
import org.psota.invoices.entity.*
import org.psota.invoices.entity.Unit

object TestUtils {
    fun buildInvoice(company: Company,
                     client: Client,
                     product: Product): Invoice {
        return Invoice(
                invoiceNo = "20240601",
                company = company,
                client = client,
                issuedOn = null,
                dueOn = null,
                products = listOf(product),
                quantity = null
        )
    }

    fun buildClient(): Client {
        return Client(
                address = buildAddress(),
                regNo = "regNo",
                taxNo = "taxNo",
                vatNo = "vatNo"
        )
    }

    fun buildAddress(): Address {
        return Address(
                streetNo = "streetNo",
                street = "street",
                city = "city",
                zipCode = "zipCode"
        )
    }

    fun buildCompany(): Company {
        return Company(
                name = "My Company",
                address = buildAddress(),
                regNo = "regNo",
                taxNo = "taxNo",
                vatNo = "vatNo",
                bankInfo = buildBankInfo(),
        )
    }

    fun buildBankInfo(): BankInfo {
        return BankInfo(
                accountNo = "accountNo",
                iban = "iban",
                bankName = "bankName",
                swiftCode = "swiftCode",
                ""
        )
    }

    fun buildProduct(): Product {
        return Product(
                name = "name",
                description = "",
                unit = Unit.MD,
                unitPrice = 1.00
        )
    }

    fun buildAddressDto(): AddressDto {
        return AddressDto(
                streetNo = "streetNo",
                street = "street",
                city = "city",
                zipCode = "zipCode"
        )
    }

    fun buildCompanyDto(): CompanyDto {
        return CompanyDto(
                null,
                name = "My Company",
                address = buildAddressDto(),
                regNo = "regNo",
                taxNo = "taxNo",
                vatNo = "vatNo",
                bankInfo = buildBankInfoDto(),
                listOf()
        )
    }

    fun buildBankInfoDto(): BankInfoDto {
        return BankInfoDto(
                accountNo = "accountNo",
                iban = "iban",
                bankName = "bankName",
                swiftCode = "swiftCode",
                ""
        )
    }
}