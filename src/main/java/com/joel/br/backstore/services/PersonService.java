package com.joel.br.backstore.services;

import com.joel.br.backstore.dto.PersonDTO;
import com.joel.br.backstore.exceptions.EntityAlreadyExists;
import com.joel.br.backstore.model.PermissionP;
import com.joel.br.backstore.model.Person;
import com.joel.br.backstore.repository.PermissionRepository;
import com.joel.br.backstore.repository.PersonRepository;
import com.joel.br.backstore.services.IMPL.PersonImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService implements PersonImpl {

    private  final PersonRepository personRepository;

    private  final MailService mailService;
    private  final PermissionRepository permissionRepository;

    public PersonService(PersonRepository personRepository, MailService mailService, PermissionRepository permissionRepository) {
        this.personRepository = personRepository;
        this.mailService = mailService;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person save(PersonDTO person) {
        Person person1 = new Person();
        BeanUtils.copyProperties(person, person1);

        UUID  uuid = UUID.randomUUID();

        List<Person> people  =  personRepository.findAll();

        for (Person p : people) {
            if (p.getEmail().equals(person.getEmail())) {
                throw  new EntityAlreadyExists("Email already exists");
            }
        }


     Person personSaved =  personRepository.save(person1);

        mailService.sendSimpleEmailMessage(personSaved.getName() , personSaved.getEmail());

        giverPermission(2L, personSaved.getId());

        return personSaved;
    }

    @Override
    public Person update(Long id, Person person) {
        Person person1 = personRepository.findById(id).get();

        BeanUtils.copyProperties(person, person1, "id" ,"address");

        return personRepository.save(person1);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
    @Transactional
    public void  giverPermission(Long id, Long idPerson) {
        PermissionP permissionP = permissionRepository.findById(id).get();
        if(permissionP == null ) {
            throw  new RuntimeException("Permission not found");
        }

        Person person = personRepository.findById(idPerson).get();
        if(person == null ) {
            throw  new RuntimeException("Person not found");
        }

        permissionP.getPerson().add(person);
        permissionRepository.save(permissionP);

    }


}
