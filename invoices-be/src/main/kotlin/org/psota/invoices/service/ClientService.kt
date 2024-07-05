package org.psota.invoices.service

import org.psota.invoices.dto.ClientDto
import org.psota.invoices.entity.Client
import org.psota.invoices.exception.NotFoundException
import org.psota.invoices.mapper.ClientMapper
import org.psota.invoices.repository.ClientRepo
import org.psota.invoices.util.Validator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClientService(
    @Autowired
    private val repo: ClientRepo,
    @Autowired
    private val mapper: ClientMapper
) {
    fun createClient(dto: ClientDto): ClientDto {
        Validator.validate(dto)
        val saved = repo.save(mapper.toEntity(dto))
        return mapper.toDto(saved)
    }

    fun updateClient(dto: ClientDto): ClientDto {
        Validator.validate(dto)
        val id = dto.id ?: throw IllegalArgumentException("Undefined ID")
        val entity = repo.findById(id)
            .orElseThrow { NotFoundException(Client::class.java, id) }

        mapper.update(entity, dto)
        val saved = repo.save(entity!!)

        return mapper.toDto(saved)
    }

    fun getClient(ids: List<UUID>): List<ClientDto> {
        if (ids.isEmpty())
            return mapper.toDtoList(repo.findAll())
        return mapper.toDtoList(repo.findAllById(ids))
    }

    fun deleteClient(id: UUID): UUID {
        repo.deleteById(id)
        return id
    }
}
