package org.psota.invoices.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class BankInfo(
        @Column(nullable = false)
        val accountNo: String,
        @Column(nullable = false)
        val iban: String,
        @Column(nullable = false)
        val bankName: String,
        @Column(nullable = false)
        val swiftCode: String,
        @Column(nullable = true)
        val paymentMethod: String
) : BaseEntity()
