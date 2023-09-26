package com.joel.br.backstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant  updatedAt;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State  state;

}
