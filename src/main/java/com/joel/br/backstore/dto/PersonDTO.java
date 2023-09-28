package com.joel.br.backstore.dto;

import com.joel.br.backstore.model.Address;
import com.joel.br.backstore.model.City;
import com.joel.br.backstore.model.Person;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class PersonDTO {


    private String name;
    private String cpf;
    private String  email;
    private Address address;

    private City city;


    public static Person  toEntity(PersonDTO personDTO) {
        Person person = new Person();
        BeanUtils.copyProperties(personDTO, person);

        return  person;
    }

    public static PersonDTO  toDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        BeanUtils.copyProperties(person, personDTO);

        return  personDTO;
    }
}
