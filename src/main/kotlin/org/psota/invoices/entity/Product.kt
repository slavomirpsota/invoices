package org.psota.invoices.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Entity
class Product(
        @Column(nullable = false)
        val name: String,
        @Column(nullable = true)
        val description: String?,
        @Enumerated(EnumType.STRING)
        val unit: Unit,
        @Column(nullable = false)
        val unitPrice: Double
) : BaseEntity()
