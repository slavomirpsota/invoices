package org.psota.invoices.service

import org.psota.invoices.dto.CompanyDto
import org.psota.invoices.mapper.CompanyMapper
import org.psota.invoices.repository.CompanyRepo
import org.psota.invoices.util.Validator
import org.springframework.stereotype.Service

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
}