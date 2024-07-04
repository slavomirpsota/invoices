package org.psota.invoices.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.jeasy.random.EasyRandom;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.psota.invoices.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@Transactional
public class PersistenceTests {
  @Autowired
  ClientRepo clientRepo;

  @Autowired
  CompanyRepo companyRepo;

  @Autowired
  InvoiceRepo invoiceRepo;

  @Autowired
  ProductRepo productRepo;

  @BeforeEach
  @Transactional
  void setup() {
    clientRepo.deleteAll();
    companyRepo.deleteAll();
    invoiceRepo.deleteAll();
    productRepo.deleteAll();
  }

  @Test
  void test_persistClient() {
    EasyRandom random = new EasyRandom();
    Client client = random.nextObject(Client.class);

    Client saved = clientRepo.save(client);

    Assertions.assertThat(client)
        .isEqualTo(saved)
        .usingRecursiveComparison();
  }
}
