package com.example.paidservicebackend.service.impl;

import com.example.paidservicebackend.model.Person;
import com.example.paidservicebackend.repository.PersonRepository;
import com.example.paidservicebackend.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findBySnils(String snils) {
        return personRepository.findBySnils(snils)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Integer save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void update(Person person) {
        personRepository.update(person);
    }

    @Override
    public void delete(Integer personId) {
        personRepository.delete(personId);
    }
}
