package com.joel.br.backstore.dto;

import com.joel.br.backstore.model.Person;
import lombok.Data;
import org.springframework.beans.BeanUtils;
@Data
public class PersonRegisterDTO {

    private String email;
    private String codeRecover;
    private  String password;

    public static Person toEntity(PersonRegisterDTO personDTO) {
        Person person = new Person();
        BeanUtils.copyProperties(personDTO, person);

        return  person;
    }

    public static PersonRegisterDTO  toDTO(Person person) {
        PersonRegisterDTO personDTO = new PersonRegisterDTO();
        BeanUtils.copyProperties(person, personDTO);

        return  personDTO;
    }

}
