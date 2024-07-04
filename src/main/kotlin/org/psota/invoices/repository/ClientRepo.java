package org.psota.invoices.repository;

import java.util.UUID;
import org.psota.invoices.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ClientRepo extends JpaRepository<Client, UUID>,
    QuerydslPredicateExecutor<Client> {

}
