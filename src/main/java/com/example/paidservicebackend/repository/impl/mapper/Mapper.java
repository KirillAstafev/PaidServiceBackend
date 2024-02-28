package com.example.paidservicebackend.repository.impl.mapper;

import com.example.paidservicebackend.model.*;
import com.example.paidservicebackend.model.builder.*;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.util.HashMap;
import java.util.Map;

public final class Mapper {
    public static final RowMapper<MedicalRecord> MEDICAL_RECORD_MAPPER = (rs, rowNum) -> MedicalRecordBuilder.builder()
            .id(rs.getInt("medical_record_id"))
            .date(rs.getDate("medical_record_date").toLocalDate())
            .note(rs.getString("medical_record_note"))
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
            .diagnosis(DiagnosisBuilder.builder()
                    .id(rs.getInt("diagnosis_id"))
                    .code(rs.getString("diagnosis_code"))
                    .name(rs.getString("diagnosis_name"))
                    .build())
            .build();

    public static final RowMapper<Diagnosis> DIAGNOSIS_MAPPER = (rs, rowNum) -> DiagnosisBuilder.builder()
            .id(rs.getInt("diagnosis_id"))
            .code(rs.getString("diagnosis_code"))
            .name(rs.getString("diagnosis_name"))
            .build();

    public static final RowMapper<Person> PERSON_MAPPER = (rs, rowNum) -> PersonBuilder.builder()
            .id(rs.getInt("person_id"))
            .firstName(rs.getString("person_first_name"))
            .middleName(rs.getString("person_middle_name"))
            .lastName(rs.getString("person_last_name"))
            .snils(rs.getString("person_snils"))
            .phoneNumber(rs.getString("person_phone_number"))
            .build();

    public static final RowMapper<Speciality> SPECIALITY_MAPPER = (rs, rowNum) -> SpecialityBuilder.builder()
            .id(rs.getInt("speciality_id"))
            .name(rs.getString("speciality_name"))
            .build();

    public static final ResultSetExtractor<Staff> SINGLE_STAFF_EXTRACTOR = rs -> {
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
    };
}
