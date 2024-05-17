package com.example.paidservicebackend.controller;

import com.example.paidservicebackend.model.MedicalRecord;
import com.example.paidservicebackend.service.record.MedicalRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Контроллер мед.записей", description = "Работа с мед.записями пациентов")
@CrossOrigin("*")
@RestController
@RequestMapping("/records")
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping
    public List<MedicalRecord> findByPatientId(@RequestParam Integer patientId) {
        return medicalRecordService.findByPatientId(patientId);
    }

    @PostMapping
    public Integer save(@RequestBody MedicalRecord record) {
        return medicalRecordService.save(record);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody MedicalRecord record) {
        medicalRecordService.update(record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        medicalRecordService.delete(id);
    }
}
