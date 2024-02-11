package com.example.paidservicebackend.model.builder;

import com.example.paidservicebackend.model.Diagnosis;

public final class DiagnosisBuilder {
    private Integer id;
    private String code;
    private String name;

    private DiagnosisBuilder() {
    }

    public static DiagnosisBuilder builder() {
        return new DiagnosisBuilder();
    }

    public DiagnosisBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public DiagnosisBuilder code(String code) {
        this.code = code;
        return this;
    }

    public DiagnosisBuilder name(String name) {
        this.name = name;
        return this;
    }

    public Diagnosis build() {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setId(id);
        diagnosis.setCode(code);
        diagnosis.setName(name);
        return diagnosis;
    }
}
