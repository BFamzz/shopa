package com.famzzie.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Customer")
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(name = "customer_unique",
                columnNames = {"email", "phone_number"})
})
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "customer_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name", nullable = false, columnDefinition = "VARCHAR(50)")
    private String firstName;

    @Column(name = "last_name", nullable = false, columnDefinition = "VARCHAR(50)")
    private String lastName;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "phone_number", nullable = false, columnDefinition = "VARCHAR(15)")
    private String phoneNumber;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime createdAt;
}