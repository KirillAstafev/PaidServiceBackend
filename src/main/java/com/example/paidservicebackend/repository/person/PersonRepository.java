package com.example.paidservicebackend.repository.person;

import com.example.paidservicebackend.model.Person;

import java.util.Optional;

public interface PersonRepository {
    Optional<Person> findBySnils(String snils);
    Integer save(Person person);
    void update(Person person);
    void delete(Integer personId);
}
