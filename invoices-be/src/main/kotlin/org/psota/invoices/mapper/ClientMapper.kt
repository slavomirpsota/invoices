package org.psota.invoices.mapper

import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.psota.invoices.dto.ClientDto
import org.psota.invoices.entity.Client

@Mapper(componentModel = "spring")
interface ClientMapper {
    fun toDto(entity: Client?): ClientDto
    fun toEntity(dto: ClientDto?): Client
    fun toDtoList(entities: MutableList<Client?>): List<ClientDto>
    fun toEntityList(dtos: List<ClientDto?>): List<Client>
    fun update(@MappingTarget entity: Client?, dto: ClientDto)
}