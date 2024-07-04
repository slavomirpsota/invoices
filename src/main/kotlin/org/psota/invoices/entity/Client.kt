package org.psota.invoices.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToOne

@Entity
class Client(
        @OneToOne(cascade = [CascadeType.ALL])
        val address: Address,
        @Column(nullable = false)
        val regNo: String,
        @Column(nullable = false)
        val taxNo: String,
        @Column(nullable = false)
        val vatNo: String
) : BaseEntity()
