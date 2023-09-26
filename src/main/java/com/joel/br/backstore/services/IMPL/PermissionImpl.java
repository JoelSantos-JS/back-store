package com.joel.br.backstore.services.IMPL;

import com.joel.br.backstore.model.PermissionP;

import java.util.List;

public interface PermissionImpl {


    List<PermissionP> getAll();
    PermissionP findById(Long id);
    PermissionP save(PermissionP permissionP);
    PermissionP update(Long id ,PermissionP permissionP);
    void delete(Long id);
}
