package com.example.paidservicebackend.controller;


import com.example.paidservicebackend.model.Staff;
import com.example.paidservicebackend.service.StaffService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public void update(@RequestBody Staff staff) {
        staffService.update(staff);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        staffService.delete(id);
    }
}
