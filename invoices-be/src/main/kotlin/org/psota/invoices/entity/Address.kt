package org.psota.invoices.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Address(
        @Column(nullable = false)
        val street: String,
        @Column(nullable = false)
        val streetNo: String,
        @Column(nullable = false)
        val city: String,
        @Column(nullable = false)
        val zipCode: String,
) : BaseEntity()
