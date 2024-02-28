package com.example.paidservicebackend.service;

import com.example.paidservicebackend.model.Person;

public interface PersonService {
    Person findBySnils(String snils);
    Integer save(Person person);
    void update(Person person);
    void delete(Integer personId);
}
