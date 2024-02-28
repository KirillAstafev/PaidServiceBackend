package com.example.paidservicebackend.repository.person.impl;

import com.example.paidservicebackend.model.Person;
import com.example.paidservicebackend.model.builder.PersonBuilder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
final class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonBuilder.builder()
                .id(rs.getInt("person_id"))
                .firstName(rs.getString("person_first_name"))
                .middleName(rs.getString("person_middle_name"))
                .lastName(rs.getString("person_last_name"))
                .snils(rs.getString("person_snils"))
                .phoneNumber(rs.getString("person_phone_number"))
                .build();
    }
}
