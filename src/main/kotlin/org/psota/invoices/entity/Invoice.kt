package org.psota.invoices.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Invoice(
        @Column(nullable = false)
        var invoiceNo: String? = null,

        @ManyToOne(cascade = [CascadeType.ALL])
        var company: Company? = null,

        @ManyToOne
        var client: Client? = null,

        @Column(nullable = true)
        var issuedOn: LocalDate? = null,

        @Column(nullable = true)
        var dueOn: LocalDate? = null,

        @ManyToMany
        var products: List<Product>? = null,

        @Column(nullable = true)
        var quantity: Double? = null
) : BaseEntity()
