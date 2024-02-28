package com.example.paidservicebackend.controller;

import com.example.paidservicebackend.model.Person;
import com.example.paidservicebackend.service.person.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public Person findBySnils(@RequestParam String snils) {
        return personService.findBySnils(snils);
    }

    @PostMapping
    public Integer save(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Person person) {
        personService.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        personService.delete(id);
    }
}
