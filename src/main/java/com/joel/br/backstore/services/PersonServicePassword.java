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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class PersonServicePassword  {

    private  final PersonRepository personRepository;

    private  final MailService mailService;
    private  final PermissionRepository permissionRepository;

    public PersonServicePassword(PersonRepository personRepository, MailService mailService, PermissionRepository permissionRepository) {
        this.personRepository = personRepository;
        this.mailService = mailService;
        this.permissionRepository = permissionRepository;
    }



    public Person requestCode(String email) {
       Person person = personRepository.findByEmail(email);
       var code = getCodeRecover(person.getCodeRecover());

       if(person != null) {
           mailService.sendSimpleEmailMessage(person.getName() , person.getEmail() , getCodeRecover(code));

       }

       return null;
    }



    public String createPassword(Person personDTO) {
        Person person = personRepository.findByEmailAndCodeRecover(personDTO.getEmail(), personDTO.getCodeRecover() );

        if(person !=null) {
            person.setPassword(personDTO.getPassword());
            person.setCodeRecover(null);
            personRepository.save(person);
            return  "Senha Cadastrada";
        }else  {
            return  "Code not valid";
        }
    }


    private  String getCodeRecover(String code) {
        var code1 = personRepository.findByCodeRecover(code);

        if (code1 != null) {
            return code1.getCodeRecover();
        }
        return  null;
    }






}
