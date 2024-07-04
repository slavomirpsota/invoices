package org.psota.invoices.repository;

import java.util.UUID;
import org.psota.invoices.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProductRepo extends JpaRepository<Product, UUID>,
    QuerydslPredicateExecutor<Product> {

}
