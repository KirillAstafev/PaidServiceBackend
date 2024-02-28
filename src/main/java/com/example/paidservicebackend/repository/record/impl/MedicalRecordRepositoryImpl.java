package com.example.paidservicebackend.repository.record.impl;

import com.example.paidservicebackend.model.MedicalRecord;
import com.example.paidservicebackend.repository.record.MedicalRecordRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class MedicalRecordRepositoryImpl implements MedicalRecordRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MedicalRecordMapper mapper;

    public MedicalRecordRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, MedicalRecordMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public List<MedicalRecord> findByPatientId(Integer patientId) {
        String sql = """
                SELECT medical_record.id         AS medical_record_id,
                   medical_record.date       AS medical_record_date,
                   medical_record.note       AS medical_record_note,
                   diagnosis.id              AS diagnosis_id,
                   diagnosis.code            AS diagnosis_code,
                   diagnosis.name            AS diagnosis_name,
                   person.id                 AS patient_id,
                   person.first_name         AS patient_first_name,
                   person.middle_name        AS patient_middle_name,
                   person.last_name          AS patient_last_name,
                   person.snils              AS patient_snils,
                   person.phone_number       AS patient_phone_number,
                   staff.id                  AS staff_id,
                   staff_person.id           AS staff_person_id,
                   staff_person.first_name   AS staff_person_first_name,
                   staff_person.middle_name  AS staff_person_middle_name,
                   staff_person.last_name    AS staff_person_last_name,
                   staff_person.snils        AS staff_person_snils,
                   staff_person.phone_number AS staff_person_phone_number
            FROM medical_record
                     INNER JOIN diagnosis ON medical_record.diagnosis_id = diagnosis.id
                     INNER JOIN person ON medical_record.patient_id = person.id
                     INNER JOIN staff ON medical_record.staff_id = staff.id
                     INNER JOIN person AS staff_person ON staff.person_id = staff_person.id
            WHERE medical_record.patient_id = :patientId
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("patientId", patientId, Types.INTEGER);

        return jdbcTemplate.query(sql, param, mapper);
    }

    @Override
    public Integer save(MedicalRecord record) {
        String sql = """
                INSERT INTO medical_record (date, patient_id, staff_id, diagnosis_id, note)
                VALUES (:date, :patientId, :staffId, :diagnosisId, :note)
                RETURNING id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("date", record.getDate())
                .addValue("patientId", record.getPatient().getId())
                .addValue("staffId", record.getStaff().getId())
                .addValue("diagnosisId", record.getDiagnosis().getId())
                .addValue("note", record.getNote());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, keyHolder);

        return keyHolder.getKeyAs(Integer.class);
    }

    @Override
    public void update(MedicalRecord record) {
        String sql = """
                UPDATE medical_record
                SET date         = :date,
                    patient_id   = :patientId,
                    staff_id     = :staffId,
                    diagnosis_id = :diagnosisId,
                    note         = :note
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("date", record.getDate())
                .addValue("patientId", record.getPatient().getId())
                .addValue("staffId", record.getStaff().getId())
                .addValue("diagnosisId", record.getDiagnosis().getId())
                .addValue("note", record.getNote())
                .addValue("id", record.getId());

        jdbcTemplate.update(sql, param);
    }

    @Override
    public void delete(Integer recordId) {
        String sql = """
                DELETE
                FROM medical_record
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", recordId, Types.INTEGER);

        jdbcTemplate.update(sql, param);
    }
}
