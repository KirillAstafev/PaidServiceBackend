package com.example.paidservicebackend.repository.visitation.impl;

import com.example.paidservicebackend.model.Visitation;
import com.example.paidservicebackend.model.builder.MedicalServiceBuilder;
import com.example.paidservicebackend.model.builder.PersonBuilder;
import com.example.paidservicebackend.model.builder.StaffBuilder;
import com.example.paidservicebackend.model.builder.VisitationBuilder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
final class VisitationMapper implements RowMapper<Visitation> {
    @Override
    public Visitation mapRow(ResultSet rs, int rowNum) throws SQLException {
        return VisitationBuilder.builder()
                .id(rs.getInt("visitation_id"))
                .dateTime(rs.getTimestamp("visitation_date_time").toLocalDateTime())
                .patient(PersonBuilder.builder()
                        .id(rs.getInt("patient_id"))
                        .firstName(rs.getString("patient_first_name"))
                        .middleName(rs.getString("patient_middle_name"))
                        .lastName(rs.getString("patient_last_name"))
                        .snils(rs.getString("patient_snils"))
                        .phoneNumber(rs.getString("patient_phone_number"))
                        .build())
                .staff(StaffBuilder.builder()
                        .id(rs.getInt("staff_id"))
                        .person(PersonBuilder.builder()
                                .id(rs.getInt("staff_person_id"))
                                .firstName(rs.getString("staff_person_first_name"))
                                .middleName(rs.getString("staff_person_middle_name"))
                                .lastName(rs.getString("staff_person_last_name"))
                                .snils(rs.getString("staff_person_snils"))
                                .phoneNumber(rs.getString("staff_person_phone_number"))
                                .build())
                        .build())
                .medicalService(MedicalServiceBuilder.builder()
                        .id(rs.getInt("medical_service_id"))
                        .name(rs.getString("medical_service_name"))
                        .price(rs.getBigDecimal("medical_service_price"))
                        .build())
                .build();
    }
}
