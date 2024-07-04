package org.psota.invoices.entity

import jakarta.annotation.Nullable
import jakarta.persistence.*

@Entity
class Company(
        @Column(nullable = false)
        val name: String,

        @OneToOne(cascade = [CascadeType.ALL])
        val address: Address,

        @Column(nullable = false)
        val regNo: String,

        @Column(nullable = false)
        val taxNo: String,

        @Column(nullable = false)
        val vatNo: String,

        @ManyToOne(cascade = [CascadeType.ALL])
        val bankInfo: BankInfo,

        @OneToMany
        @Nullable
        val invoices: List<Invoice> = ArrayList()
) : BaseEntity()
