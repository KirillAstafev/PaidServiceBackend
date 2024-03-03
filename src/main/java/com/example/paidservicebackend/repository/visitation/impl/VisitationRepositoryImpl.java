package com.example.paidservicebackend.repository.visitation.impl;

import com.example.paidservicebackend.model.Visitation;
import com.example.paidservicebackend.repository.visitation.VisitationRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class VisitationRepositoryImpl implements VisitationRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final VisitationMapper mapper;

    public VisitationRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, VisitationMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public List<Visitation> findAll() {
        String sql = """
                SELECT visitation.id             AS visitation_id,
                       visitation.date_time      AS visitation_date_time,
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
                       staff_person.phone_number AS staff_person_phone_number,
                       medical_service.id        AS medical_service_id,
                       medical_service.name      AS medical_service_name,
                       medical_service.price     AS medical_service_price
                FROM visitation
                         INNER JOIN person ON visitation.patient_id = person.id
                         INNER JOIN staff ON visitation.staff_id = staff.id
                         INNER JOIN person AS staff_person ON staff.person_id = staff_person.id
                         INNER JOIN medical_service ON visitation.medical_service_id = medical_service.id
                """;

        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Integer save(Visitation visitation) {
        String sql = """
                INSERT INTO visitation (patient_id, staff_id, medical_service_id, date_time)
                VALUES (:patientId, :staffId, :medicalServiceId, :dateTime)
                RETURNING id
                """;
        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("patientId", visitation.getPatient().getId())
                .addValue("staffId", visitation.getStaff().getId())
                .addValue("medicalServiceId", visitation.getMedicalService().getId())
                .addValue("dateTime", visitation.getDateTime(), Types.TIMESTAMP);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, keyHolder);

        return keyHolder.getKeyAs(Integer.class);
    }

    @Override
    public void update(Visitation visitation) {
        String sql = """
                UPDATE visitation
                SET patient_id         = :patientId,
                    staff_id           = :staffId,
                    medical_service_id = :medicalServiceId,
                    date_time          = :dateTime
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("patientId", visitation.getPatient().getId())
                .addValue("staffId", visitation.getStaff().getId())
                .addValue("medicalServiceId", visitation.getMedicalService().getId())
                .addValue("dateTime", visitation.getDateTime(), Types.TIMESTAMP)
                .addValue("id", visitation.getId());

        jdbcTemplate.update(sql, param);
    }

    @Override
    public void delete(Integer visitationId) {
        String sql = """
                DELETE FROM visitation
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", visitationId);

        jdbcTemplate.update(sql, param);
    }
}
