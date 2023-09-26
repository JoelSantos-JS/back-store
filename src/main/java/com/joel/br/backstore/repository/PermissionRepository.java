package com.joel.br.backstore.repository;

import com.joel.br.backstore.model.PermissionP;
import com.joel.br.backstore.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PermissionRepository  extends JpaRepository<PermissionP, Long> {


    @Query("SELECT p.person FROM PermissionP p WHERE p.id = :permissionId")
    List<Person> findUsersByPermissionId(@Param("permissionId") Long permissionId);
}

