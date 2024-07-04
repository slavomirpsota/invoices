package org.psota.invoices.entity;

import jakarta.persistence.Entity;
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
public class BankInfo extends BaseEntity {

  private String accountNo;
  private String iban;
  private String bankName;
  private String swiftCode;
  private String paymentMethod;

}
