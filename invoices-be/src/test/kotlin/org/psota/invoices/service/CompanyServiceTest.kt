package org.psota.invoices.service

import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.psota.invoices.TestUtils
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
        val companyDto = TestUtils.buildCompanyDto()

        //When
        val savedCompanyDto = service.createCompany(companyDto)

        //Then
        val savedCompany = mapper.toDto(repo.findById(savedCompanyDto.id!!)
                .orElse(null))
        Assertions.assertThat(savedCompanyDto).usingRecursiveComparison().isEqualTo(savedCompany)
    }

    @Test
    fun test_updateCompany() {
        //Given
        val company = TestUtils.buildCompany()
        val companyUpdateDto = TestUtils.buildCompanyDto()

        val saved = repo.save(company)

        companyUpdateDto.name = "Updated company name"
        companyUpdateDto.id = saved.id

        //When
        val updated = service.updateCompany(companyUpdateDto)

        //Then
        Assertions.assertThat(updated.name).isEqualTo(companyUpdateDto.name)
    }

    @Test
    fun test_getCompanies() {
        //Given
        val company1 = TestUtils.buildCompany()
        val company2 = TestUtils.buildCompany()
        company1.name = "Company1"
        company2.name = "Company2"
        repo.saveAll(listOf(company1, company2))

        //When
        val companies = service.getCompany(listOf())

        //Then
        Assertions.assertThat(companies.size).isEqualTo(2)
        Assertions.assertThat(companies.map { it.name }).containsExactlyInAnyOrder("Company1", "Company2")

    }

    @Test
    fun test_deleteCompany() {
        //Given
        val company = TestUtils.buildCompany()

        val saved = repo.save(company)

        //When
        val deleted = service.deleteCompany(saved.id)

        //Then
        Assertions.assertThat(deleted).isEqualTo(saved.id)
    }

}