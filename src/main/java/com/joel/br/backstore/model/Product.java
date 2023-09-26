package com.joel.br.backstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 500)
    private String description;
    private BigDecimal  price;
    private BigDecimal salePrice;



    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;





    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant  updatedAt;


}
