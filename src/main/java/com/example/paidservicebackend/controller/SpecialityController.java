package com.example.paidservicebackend.controller;

import com.example.paidservicebackend.model.Speciality;
import com.example.paidservicebackend.service.speciality.SpecialityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Контроллер специальностей", description = "Работа с реестром мед.специальностей")
@RestController
@RequestMapping("/specialities")
public class SpecialityController {
    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping
    public List<Speciality> findAll() {
        return specialityService.findAll();
    }

    @PostMapping
    public Integer save(@RequestBody Speciality speciality) {
        return specialityService.save(speciality);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Speciality speciality) {
        specialityService.update(speciality);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        specialityService.delete(id);
    }
}
