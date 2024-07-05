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
}