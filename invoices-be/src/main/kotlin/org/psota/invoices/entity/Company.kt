package org.psota.invoices.entity

import jakarta.annotation.Nullable
import jakarta.persistence.*

@Entity
class Company(
        @Column(nullable = false)
        var name: String,

        @OneToOne(cascade = [CascadeType.ALL])
        var address: Address,

        @Column(nullable = false)
        var regNo: String,

        @Column(nullable = false)
        var taxNo: String,

        @Column(nullable = false)
        var vatNo: String,

        @ManyToOne(cascade = [CascadeType.ALL])
        var bankInfo: BankInfo,

        @OneToMany
        @Nullable
        var invoices: List<Invoice> = ArrayList()
) : BaseEntity()
