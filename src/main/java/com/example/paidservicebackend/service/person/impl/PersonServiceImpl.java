package com.example.paidservicebackend.service.person.impl;

import com.example.paidservicebackend.exception.PersonNotFoundException;
import com.example.paidservicebackend.model.Person;
import com.example.paidservicebackend.repository.person.PersonRepository;
import com.example.paidservicebackend.service.person.PersonService;
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
                .orElseThrow(() -> new PersonNotFoundException("Ошибка! Пациент с номером СНИЛС '%s' не найден!".formatted(snils)));
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
