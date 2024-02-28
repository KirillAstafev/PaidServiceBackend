package com.example.paidservicebackend.repository.diagnosis.impl;

import com.example.paidservicebackend.model.Diagnosis;
import com.example.paidservicebackend.model.builder.DiagnosisBuilder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
final class DiagnosisMapper implements RowMapper<Diagnosis> {

    @Override
    public Diagnosis mapRow(ResultSet rs, int rowNum) throws SQLException {
        return DiagnosisBuilder.builder()
                .id(rs.getInt("diagnosis_id"))
                .code(rs.getString("diagnosis_code"))
                .name(rs.getString("diagnosis_name"))
                .build();
    }
}
