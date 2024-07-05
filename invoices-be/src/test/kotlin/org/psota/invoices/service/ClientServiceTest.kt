package org.psota.invoices.service

import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.psota.invoices.TestUtils
import org.psota.invoices.mapper.ClientMapper
import org.psota.invoices.repository.ClientRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Transactional
class ClientServiceTest {

    @Autowired
    lateinit var service: ClientService
    @Autowired
    lateinit var repo: ClientRepo
    @Autowired
    lateinit var mapper: ClientMapper
    @Test
    fun test_createClient() {
        //Given
        val dto = TestUtils.buildClientDto()

        //When
        val savedClientDto = service.createClient(dto)

        //Then
        val saved = mapper.toDto(
            repo.findById(savedClientDto.id!!)
                .orElse(null)
        )
        Assertions.assertThat(saved).usingRecursiveComparison().isEqualTo(savedClientDto)
    }

    @Test
    fun test_updateClient() {
        //Given
        val client = TestUtils.buildClient()
        val clientUpdateDto = TestUtils.buildClientDto()

        val saved = repo.save(client)

        clientUpdateDto.regNo = "Updated regNo"
        clientUpdateDto.id = saved.id

        //When
        val updated = service.updateClient(clientUpdateDto)

        //Then
        Assertions.assertThat(updated.regNo).isEqualTo(clientUpdateDto.regNo)
    }

    @Test
    fun test_getCompanies() {
        //Given
        val client1 = TestUtils.buildClient()
        val client2 = TestUtils.buildClient()
        client1.regNo = "regNo1"
        client2.regNo = "regNo1"
        repo.saveAll(listOf(client1, client2))

        //When
        val companies = service.getClient(listOf())

        //Then
        Assertions.assertThat(companies.size).isEqualTo(2)
        Assertions.assertThat(companies.map { it.regNo }).containsExactlyInAnyOrder("regNo1", "regNo2")

    }

    @Test
    fun test_deleteClient() {
        //Given
        val company = TestUtils.buildClient()

        val saved = repo.save(company)

        //When
        val deleted = service.deleteClient(saved.id)

        //Then
        Assertions.assertThat(deleted).isEqualTo(saved.id)
        Assertions.assertThatThrownBy { repo.findById(saved.id)
            .orElseThrow { IllegalArgumentException() }
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}