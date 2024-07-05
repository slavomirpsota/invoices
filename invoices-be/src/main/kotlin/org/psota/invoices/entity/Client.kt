package org.psota.invoices.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToOne

@Entity
class Client(
        @OneToOne(cascade = [CascadeType.ALL])
        var address: Address,
        @Column(nullable = false)
        var regNo: String,
        @Column(nullable = false)
        var taxNo: String,
        @Column(nullable = false)
        var vatNo: String
) : BaseEntity()
