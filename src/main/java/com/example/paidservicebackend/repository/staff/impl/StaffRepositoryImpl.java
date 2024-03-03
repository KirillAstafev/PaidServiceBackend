package com.example.paidservicebackend.repository.staff.impl;

import com.example.paidservicebackend.model.Staff;
import com.example.paidservicebackend.repository.staff.StaffRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StaffRepositoryImpl implements StaffRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SingleStaffExtractor extractor;

    public StaffRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, SingleStaffExtractor extractor) {
        this.jdbcTemplate = jdbcTemplate;
        this.extractor = extractor;
    }

    @Override
    public Optional<Staff> findById(Integer id) {
        String sql = """
                SELECT staff.id            AS staff_id,
                       person.id           AS staff_person_id,
                       person.first_name   AS staff_person_first_name,
                       person.middle_name  AS staff_person_middle_name,
                       person.last_name    AS staff_person_last_name,
                       person.snils        AS staff_person_snils,
                       person.phone_number AS staff_person_phone_number,
                       speciality.id       AS staff_speciality_id,
                       speciality.name     AS staff_speciality_id
                FROM staff
                         INNER JOIN person ON staff.person_id = person.id
                         INNER JOIN staff_speciality ON staff.id = staff_speciality.staff_id
                         INNER JOIN speciality ON staff_speciality.speciality_id = speciality.id
                WHERE staff.id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);

        return Optional.ofNullable(jdbcTemplate.query(sql, param, extractor));
    }

    @Override
    public Integer save(Staff staff) {
        String sql = """
                INSERT INTO staff (person_id, user_id)
                VALUES (:personId, :userId)
                RETURNING id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("personId", staff.getPerson().getId())
                .addValue("userId", staff.getUser().getId());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, keyHolder);

        return keyHolder.getKeyAs(Integer.class);
    }

    @Override
    public void delete(Integer staffId) {
        String sql = """
                DELETE FROM staff
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", staffId);

        jdbcTemplate.update(sql, param);
    }
}
