package com.example.paidservicebackend.repository.impl.mapper;

import com.example.paidservicebackend.model.Diagnosis;
import com.example.paidservicebackend.model.MedicalRecord;
import com.example.paidservicebackend.model.builder.DiagnosisBuilder;
import com.example.paidservicebackend.model.builder.MedicalRecordBuilder;
import com.example.paidservicebackend.model.builder.PersonBuilder;
import com.example.paidservicebackend.model.builder.StaffBuilder;
import org.springframework.jdbc.core.RowMapper;

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
}
