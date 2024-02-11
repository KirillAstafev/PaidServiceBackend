package com.example.paidservicebackend.model.builder;

import com.example.paidservicebackend.model.MedicalService;

import java.math.BigDecimal;

public final class MedicalServiceBuilder {
    private Integer id;
    private String name;
    private BigDecimal price;

    private MedicalServiceBuilder() {
    }

    public static MedicalServiceBuilder builder() {
        return new MedicalServiceBuilder();
    }

    public MedicalServiceBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public MedicalServiceBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MedicalServiceBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public MedicalService build() {
        MedicalService medicalService = new MedicalService();
        medicalService.setId(id);
        medicalService.setName(name);
        medicalService.setPrice(price);
        return medicalService;
    }
}
