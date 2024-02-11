package com.example.paidservicebackend.model.builder;

import com.example.paidservicebackend.model.Person;
import com.example.paidservicebackend.model.Speciality;
import com.example.paidservicebackend.model.Staff;
import com.example.paidservicebackend.model.User;

import java.util.List;

public final class StaffBuilder {
    private Integer id;
    private Person person;
    private User user;
    private List<Speciality> specialities;

    private StaffBuilder() {
    }

    public static StaffBuilder builder() {
        return new StaffBuilder();
    }

    public StaffBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public StaffBuilder person(Person person) {
        this.person = person;
        return this;
    }

    public StaffBuilder user(User user) {
        this.user = user;
        return this;
    }

    public StaffBuilder specialities(List<Speciality> specialities) {
        this.specialities = specialities;
        return this;
    }

    public Staff build() {
        Staff staff = new Staff();
        staff.setId(id);
        staff.setPerson(person);
        staff.setUser(user);
        staff.setSpecialities(specialities);
        return staff;
    }
}
