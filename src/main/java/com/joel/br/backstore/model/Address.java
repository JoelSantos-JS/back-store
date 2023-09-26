package com.joel.br.backstore.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {


    private String street;
    private String number;

    private String zipCode;


}


