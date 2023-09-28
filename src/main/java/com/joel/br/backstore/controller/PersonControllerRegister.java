package com.joel.br.backstore.controller;

import com.joel.br.backstore.dto.PersonDTO;
import com.joel.br.backstore.dto.PersonRegisterDTO;
import com.joel.br.backstore.model.Person;
import com.joel.br.backstore.services.PersonService;
import com.joel.br.backstore.services.PersonServicePassword;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person-register")
public class PersonControllerRegister {

    private final PersonServicePassword personService;

    public PersonControllerRegister(PersonServicePassword personService) {
        this.personService = personService;
    }


    @PostMapping("/")
    public ResponseEntity<Person> getById(@RequestParam("email") String  email) {
        return ResponseEntity.ok().body(personService.requestCode(email));
    }

    @PostMapping("/create-password")
    public ResponseEntity<String> createPassowrd(@RequestBody PersonRegisterDTO personRegisterDTO) {
        Person person = PersonRegisterDTO.toEntity(personRegisterDTO);
        return ResponseEntity.ok().body(personService.createPassword(person));
    }


}
