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
                SELECT *
                FROM visitation
                INNER JOIN person ON visitation.patient_id = person.id
                INNER JOIN staff ON visitation.staff_id = staff.id
                INNER JOIN person AS staff_person ON staff.person_id = staff_person.id
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
                SET patient_id = :patientId,
                staff_id = :staffId,
                medical_service_id = :medicalServiceId,
                date_time = :dateTime
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("patientId", visitation.getPatient().getId())
                .addValue("staffId", visitation.getStaff().getId())
                .addValue("medicalServiceId", visitation.getMedicalService().getId())
                .addValue("dateTime", visitation.getDateTime(), Types.TIMESTAMP);

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
