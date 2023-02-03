package com.famzzie.cart.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Cart")
@Table(name = "cart",
        indexes = { @Index(name = "customer_id_idx", columnList = "customer_id") },
        uniqueConstraints = {
            @UniqueConstraint(name = "customer_id_unique", columnNames = { "customer_id" })
        }
)
public class Cart {
    @Id
    @SequenceGenerator(name = "cart_id_sequence", sequenceName = "cart_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "cart_id_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @ElementCollection
    @CollectionTable(name = "cart_items", foreignKey = @ForeignKey(name = "cart_id_fk"))
    private final List<CartItem> cartItems = new ArrayList<>();
}
