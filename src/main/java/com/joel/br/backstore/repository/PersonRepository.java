package com.joel.br.backstore.repository;

import com.joel.br.backstore.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


    Person findByEmail(String email);
    Person findByCodeRecover(String code);


   Person findByEmailAndCodeRecover(String email , String code) ;
}
