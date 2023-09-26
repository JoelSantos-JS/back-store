package com.joel.br.backstore.repository;

import com.joel.br.backstore.model.PermissionP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository  extends JpaRepository<PermissionP, Long> {
}
