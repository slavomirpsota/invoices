package org.psota.invoices.repository;

import java.util.UUID;
import org.psota.invoices.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface InvoiceRepo extends JpaRepository<Invoice, UUID>,
    QuerydslPredicateExecutor<Invoice> {

}
