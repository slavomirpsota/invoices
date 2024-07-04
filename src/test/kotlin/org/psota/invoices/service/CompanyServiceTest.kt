package org.psota.invoices.service

import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.psota.invoices.dto.AddressDto
import org.psota.invoices.dto.BankInfoDto
import org.psota.invoices.dto.CompanyDto
import org.psota.invoices.mapper.CompanyMapper
import org.psota.invoices.repository.CompanyRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Transactional
class CompanyServiceTest {

    @Autowired
    lateinit var service: CompanyService

    @Autowired
    lateinit var repo: CompanyRepo

    @Autowired
    lateinit var mapper: CompanyMapper

    @Test
    fun test_createCompany() {
        //Given
        val addressDto = buildAddressDto()
        val bankInfoDto = buildBankInfoDto()
        val companyDto = buildCompanyDto(addressDto, bankInfoDto)

        //When
        val savedCompanyDto = service.createCompany(companyDto)

        //Then
        val savedCompany = mapper.toDto(repo.findById(savedCompanyDto.id!!)
                .orElse(null))
        Assertions.assertThat(savedCompanyDto).usingRecursiveComparison().isEqualTo(savedCompany)
    }

    fun buildAddressDto(): AddressDto {
        return AddressDto(
                streetNo = "streetNo",
                street = "street",
                city = "city",
                zipCode = "zipCode"
        )
    }

    fun buildCompanyDto(address: AddressDto, bankInfo: BankInfoDto): CompanyDto {
        return CompanyDto(
                null,
                name = "My Company",
                address = address,
                regNo = "regNo",
                taxNo = "taxNo",
                vatNo = "vatNo",
                bankInfo = bankInfo,
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