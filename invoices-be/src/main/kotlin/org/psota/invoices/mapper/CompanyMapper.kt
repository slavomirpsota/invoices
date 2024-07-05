package org.psota.invoices.mapper

import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.psota.invoices.dto.CompanyDto
import org.psota.invoices.entity.Company

@Mapper(componentModel = "spring")
interface CompanyMapper {
    fun toDto(entity: Company?): CompanyDto
    fun toEntity(dto: CompanyDto?): Company
    fun toDtoList(entities: MutableList<Company?>): List<CompanyDto>
    fun toEntityList(dtos: List<CompanyDto?>): List<Company>
    fun update(@MappingTarget entity: Company?, dto: CompanyDto)

}
