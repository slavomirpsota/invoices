package org.psota.invoices.repository;

import java.util.UUID;
import org.psota.invoices.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, UUID>,
    QuerydslPredicateExecutor<Company> {

}
