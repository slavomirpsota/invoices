package org.psota.invoices.mapper

import org.mapstruct.Mapper
import org.psota.invoices.dto.CompanyDto
import org.psota.invoices.entity.Company

@Mapper(componentModel = "spring")
interface CompanyMapper {
    fun toDto(`in`: Company?): CompanyDto?
}
