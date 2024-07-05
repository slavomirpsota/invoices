package org.psota.invoices.service

import org.psota.invoices.dto.CompanyDto
import org.psota.invoices.entity.Company
import org.psota.invoices.exception.NotFoundException
import org.psota.invoices.mapper.CompanyMapper
import org.psota.invoices.repository.CompanyRepo
import org.psota.invoices.util.Validator
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyService(
        private val repo: CompanyRepo,
        private val mapper: CompanyMapper
) {
    fun createCompany(dto: CompanyDto): CompanyDto {
        Validator.validate(dto)
        val toEntity = mapper.toEntity(dto)
        val saved = repo.save(toEntity)
        return mapper.toDto(saved)
    }

    fun createCompany(dtos: List<CompanyDto>): List<CompanyDto> {
        dtos.forEach(Validator::validate)
        val saved = repo.saveAll(mapper.toEntityList(dtos))
        return mapper.toDtoList(saved)
    }

    fun updateCompany(dto: CompanyDto): CompanyDto {
        Validator.validate(dto)
        val id = dto.id ?: throw IllegalArgumentException("Undefined ID")
        val entity = repo.findById(id)
                .orElseThrow { NotFoundException(Company::class.java, id) }

        mapper.update(entity, dto)

        val savedEntity = repo.save(entity!!)
        return mapper.toDto(savedEntity)
    }

    fun getCompany(ids: List<UUID>): List<CompanyDto> {
        if (ids.isEmpty())
            return mapper.toDtoList(repo.findAll())
        return mapper.toDtoList(repo.findAllById(ids))
    }

    fun deleteCompany(id: UUID): UUID {
        repo.deleteById(id)
        return id
    }
}