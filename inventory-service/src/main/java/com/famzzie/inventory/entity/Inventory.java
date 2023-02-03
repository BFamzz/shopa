package com.famzzie.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Inventory")
@Table(name = "inventory")
public class Inventory {

    @Id
    @SequenceGenerator(name = "inventory_id_sequence", sequenceName = "inventory_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "inventory_id_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", updatable = false, nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(name = "quantity", nullable = false, columnDefinition = "BIGINT")
    private Long quantity;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()")
    private LocalDateTime updatedAt;
}
