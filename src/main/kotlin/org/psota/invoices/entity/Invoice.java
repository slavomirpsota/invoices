package org.psota.invoices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED) // for JPA
@Getter
@Entity
public class Invoice extends BaseEntity {

  private String invoiceNo;
  @ManyToOne
  private Company company;
  @ManyToOne
  private Client client;
  private LocalDate issuedOn;
  private LocalDate dueOn;
  @ManyToMany
  private List<Product> products;
  private Double quantity;

}
