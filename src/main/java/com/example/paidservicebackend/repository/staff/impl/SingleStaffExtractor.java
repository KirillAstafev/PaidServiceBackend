package com.example.paidservicebackend.repository.staff.impl;

import com.example.paidservicebackend.model.Staff;
import com.example.paidservicebackend.model.builder.PersonBuilder;
import com.example.paidservicebackend.model.builder.SpecialityBuilder;
import com.example.paidservicebackend.model.builder.StaffBuilder;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
final class SingleStaffExtractor implements ResultSetExtractor<Staff> {
    @Override
    public Staff extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Staff> staffMap = new HashMap<>();
        Integer staffId = null;

        while (rs.next()) {
            staffId = rs.getInt("staff_id");

            if (!staffMap.containsKey(staffId)) {
                Staff newStaff = StaffBuilder.builder()
                        .id(staffId)
                        .person(PersonBuilder.builder()
                                .id(rs.getInt("staff_person_id"))
                                .firstName(rs.getString("staff_person_first_name"))
                                .middleName(rs.getString("staff_person_middle_name"))
                                .lastName(rs.getString("staff_person_last_name"))
                                .snils(rs.getString("staff_person_snils"))
                                .phoneNumber(rs.getString("staff_person_phone_number"))
                                .build())
                        .build();

                staffMap.put(staffId, newStaff);
            }

            Staff staff = staffMap.get(staffId);

            staff.getSpecialities().add(SpecialityBuilder.builder()
                    .id(rs.getInt("staff_speciality_id"))
                    .name(rs.getString("staff_speciality_name"))
                    .build());
        }

        return staffMap.get(staffId);
    }
}
