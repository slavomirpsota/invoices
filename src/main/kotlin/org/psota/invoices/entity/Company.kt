package org.psota.invoices.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Company extends BaseEntity {

  private String name;
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;
  private String regNo;
  private String taxNo;
  private String vatNo;
  @ManyToOne(cascade = CascadeType.ALL)
  private BankInfo bankInfo;
  @OneToMany
  private List<Invoice> invoices;
}
