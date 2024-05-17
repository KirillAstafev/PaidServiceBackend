package com.example.paidservicebackend.controller;

import com.example.paidservicebackend.model.Visitation;
import com.example.paidservicebackend.service.visitation.VisitationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Контроллер посещений", description = "Работа с информацией о посещениях клиники")
@CrossOrigin("*")
@RestController
@RequestMapping("/visitations")
public class VisitationController {
    private final VisitationService visitationService;

    public VisitationController(VisitationService visitationService) {
        this.visitationService = visitationService;
    }

    @GetMapping
    public List<Visitation> findAll() {
        return visitationService.findAll();
    }

    @PostMapping
    public Integer save(@RequestBody Visitation visitation) {
        return visitationService.save(visitation);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Visitation visitation) {
        visitationService.update(visitation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        visitationService.delete(id);
    }
}
