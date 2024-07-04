package org.psota.invoices.entity

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.*

/**
 * Base for all entities with random ID.
 */

@MappedSuperclass
open class BaseEntity {
    /**
     * Artificial primary key.
     */
    @Id
    val id: UUID = UUID.randomUUID()

    /**
     * Creation time.
     */
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    var createdAt: Instant? = null

    /**
     * Last update time.
     */
    @UpdateTimestamp
    val updatedAt: Instant? = null
}
