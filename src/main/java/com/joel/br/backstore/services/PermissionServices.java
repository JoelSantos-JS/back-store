package com.joel.br.backstore.services;

import com.joel.br.backstore.model.PermissionP;
import com.joel.br.backstore.model.Person;
import com.joel.br.backstore.repository.PermissionRepository;
import com.joel.br.backstore.repository.PersonRepository;
import com.joel.br.backstore.services.IMPL.PermissionImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServices implements PermissionImpl {

    private final PermissionRepository permissionRepository;
    private  final PersonRepository personRepository;

    public PermissionServices(PermissionRepository permissionRepository, PersonRepository personRepository) {
        this.permissionRepository = permissionRepository;
        this.personRepository = personRepository;
    }

    @Override
    public List<PermissionP> getAll() {
        return permissionRepository.findAll();
    }

    @Override
    public PermissionP findById(Long id) {
        return permissionRepository.findById(id).get();
    }

    @Override
    public PermissionP save(PermissionP permissionP) {
        return permissionRepository.save(permissionP);
    }

    @Override
    public PermissionP update(Long id, PermissionP permissionP) {
        PermissionP permissionP1 = findById(id);

        if (permissionP1 != null) {
            BeanUtils.copyProperties(permissionP, permissionP1, "id");
            return permissionRepository.save(permissionP1);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        permissionRepository.deleteById(id);
    }


    public List<Person>  getAllPerson(long id) {
        return permissionRepository.findUsersByPermissionId(id);
    }

    @Transactional
    public void  giverPermission(Long id, Long idPerson) {
        PermissionP permissionP = findById(id);
        Person person = personRepository.findById(idPerson).get();

        permissionP.getPerson().add(person);

    }

    @Transactional
    public void  removePermission(Long id, Long idPerson) {
        PermissionP permissionP = findById(id);
        Person person = personRepository.findById(idPerson).get();

        permissionP.getPerson().remove(person);

    }

}
