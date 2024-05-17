package com.example.paidservicebackend.controller;

import com.example.paidservicebackend.model.MedicalService;
import com.example.paidservicebackend.service.service.MedicalServiceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Контроллер мед.услуг", description = "Работа с информацией о мед.услугах клиники")
@CrossOrigin("*")
@RestController
@RequestMapping("/services")
public class MedicalServiceController {
    private final MedicalServiceService service;

    public MedicalServiceController(MedicalServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<MedicalService> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Integer save(@RequestBody MedicalService medicalService) {
        return service.save(medicalService);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody MedicalService medicalService) {
        service.update(medicalService);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
