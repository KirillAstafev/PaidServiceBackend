package com.example.paidservicebackend.model.builder;

import com.example.paidservicebackend.model.Person;

public final class PersonBuilder {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String snils;
    private String phoneNumber;

    private PersonBuilder() {
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public PersonBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public PersonBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public PersonBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder snils(String snils) {
        this.snils = snils;
        return this;
    }

    public PersonBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Person build() {
        Person person = new Person();
        person.setId(id);
        person.setFirstName(firstName);
        person.setMiddleName(middleName);
        person.setLastName(lastName);
        person.setSnils(snils);
        person.setPhoneNumber(phoneNumber);
        return person;
    }
}
