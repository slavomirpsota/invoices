package org.psota.invoices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.time.Instant;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Base for all entities with random ID.
 */
@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED) // for JPA
@Getter
public class BaseEntity {

  /**
   * Artificial primary key.
   */
  @EqualsAndHashCode.Include
  @NonNull
  @Builder.Default
  @Id
  private UUID id = UUID.randomUUID();

  /**
   * Creation time.
   */
  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private Instant createdAt;

  /**
   * Last update time.
   */
  @UpdateTimestamp
  private Instant updatedAt;

}
