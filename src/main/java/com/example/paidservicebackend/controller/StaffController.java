package com.example.paidservicebackend.controller;


import com.example.paidservicebackend.model.Staff;
import com.example.paidservicebackend.service.staff.StaffService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Контроллер мед.персонала", description = "Работа с данными мед.персонала клиники")
@RestController
@RequestMapping("/staffs")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/{id}")
    public Staff findById(@PathVariable Integer id) {
        return staffService.findById(id);
    }

    @PostMapping
    public Integer save(@RequestBody Staff staff) {
        return staffService.save(staff);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        staffService.delete(id);
    }
}
