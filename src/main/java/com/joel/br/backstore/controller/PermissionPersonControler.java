package com.joel.br.backstore.controller;

import com.joel.br.backstore.model.Person;
import com.joel.br.backstore.services.PermissionServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission/{idPermission}/permissionPerson")
public class PermissionPersonControler {

    private  final PermissionServices permissionServices;

    public PermissionPersonControler(PermissionServices permissionServices) {
        this.permissionServices = permissionServices;

    }




    @PostMapping(value = "/{idPerson}")
    public ResponseEntity<Void> givePermission(@PathVariable Long idPermission, @PathVariable Long idPerson ){
            permissionServices.giverPermission(idPermission, idPerson);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{idPerson}")
    public ResponseEntity<Void> revokePermission(@PathVariable Long idPermission, @PathVariable Long idPerson ){
        permissionServices.removePermission(idPermission, idPerson);
        return ResponseEntity.noContent().build();
    }

}
