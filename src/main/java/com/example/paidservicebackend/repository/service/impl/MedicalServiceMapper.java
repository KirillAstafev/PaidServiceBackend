package com.example.paidservicebackend.repository.service.impl;

import com.example.paidservicebackend.model.MedicalService;
import com.example.paidservicebackend.model.builder.MedicalServiceBuilder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
final class MedicalServiceMapper implements RowMapper<MedicalService> {
    @Override
    public MedicalService mapRow(ResultSet rs, int rowNum) throws SQLException {
        return MedicalServiceBuilder.builder()
                .id(rs.getInt("service_id"))
                .name(rs.getString("service_name"))
                .price(rs.getBigDecimal("service_price"))
                .build();
    }
}
