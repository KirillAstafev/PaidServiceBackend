package com.example.paidservicebackend.repository.visitation.impl;

import com.example.paidservicebackend.model.Visitation;
import com.example.paidservicebackend.model.builder.VisitationBuilder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

//@todo сделать маппер

@Component
final class VisitationMapper implements RowMapper<Visitation> {
    @Override
    public Visitation mapRow(ResultSet rs, int rowNum) throws SQLException {
        return VisitationBuilder.builder()
                .build();
    }
}
