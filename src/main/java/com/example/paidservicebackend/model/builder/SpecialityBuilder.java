package com.example.paidservicebackend.model.builder;

import com.example.paidservicebackend.model.Speciality;

public final class SpecialityBuilder {
    private Integer id;
    private String name;

    private SpecialityBuilder() {
    }

    public static SpecialityBuilder builder() {
        return new SpecialityBuilder();
    }

    public SpecialityBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public SpecialityBuilder name(String name) {
        this.name = name;
        return this;
    }

    public Speciality build() {
        Speciality speciality = new Speciality();
        speciality.setId(id);
        speciality.setName(name);
        return speciality;
    }
}
