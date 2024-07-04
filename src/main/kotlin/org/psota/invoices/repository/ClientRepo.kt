package org.psota.invoices.repository

import org.psota.invoices.entity.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import java.util.*

interface ClientRepo : JpaRepository<Client?, UUID?>, QuerydslPredicateExecutor<Client?>
