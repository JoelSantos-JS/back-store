package com.joel.br.backstore.services;

import com.joel.br.backstore.exceptions.EntityAlreadyExists;
import com.joel.br.backstore.model.Person;
import com.joel.br.backstore.repository.PersonRepository;
import com.joel.br.backstore.services.IMPL.PersonImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonService implements PersonImpl {

    private  final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
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
    public Person save(Person person) {
        List<Person> people  =  personRepository.findAll();

        for (Person p : people) {
            if (p.getEmail().equals(person.getEmail())) {
                throw  new EntityAlreadyExists("Email already exists");
            }
        }
        return personRepository.save(person);
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
}
