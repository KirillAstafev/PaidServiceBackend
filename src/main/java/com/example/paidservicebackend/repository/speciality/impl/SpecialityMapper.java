package com.example.paidservicebackend.repository.speciality.impl;

import com.example.paidservicebackend.model.Speciality;
import com.example.paidservicebackend.model.builder.SpecialityBuilder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
final class SpecialityMapper implements RowMapper<Speciality> {
    @Override
    public Speciality mapRow(ResultSet rs, int rowNum) throws SQLException {
        return SpecialityBuilder.builder()
                .id(rs.getInt("speciality_id"))
                .name(rs.getString("speciality_name"))
                .build();
    }
}
