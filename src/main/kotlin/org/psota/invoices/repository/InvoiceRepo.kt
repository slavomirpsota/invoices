package org.psota.invoices.repository

import org.psota.invoices.entity.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import java.util.*

interface InvoiceRepo : JpaRepository<Invoice?, UUID?>, QuerydslPredicateExecutor<Invoice?>
