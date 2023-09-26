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
public class PermissionP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToMany
    @JoinTable(name = "person_permission", joinColumns = @JoinColumn(name = "permission_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Person person;



    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant  updatedAt;


}
