package com.example.paidservicebackend.repository.speciality.impl;

import com.example.paidservicebackend.model.Speciality;
import com.example.paidservicebackend.repository.speciality.SpecialityRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecialityRepositoryImpl implements SpecialityRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SpecialityMapper mapper;

    public SpecialityRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, SpecialityMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public List<Speciality> findAll() {
        String sql = """
                SELECT id   AS speciality_id,
                       name AS speciality_name
                FROM speciality
                """;

        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Integer save(Speciality speciality) {
        String sql = """
                INSERT INTO speciality (name)
                VALUES (:name)
                RETURNING id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", speciality.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, keyHolder);

        return keyHolder.getKeyAs(Integer.class);
    }

    @Override
    public void update(Speciality speciality) {
        String sql = """
                UPDATE speciality
                SET name = :name
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", speciality.getId())
                .addValue("name", speciality.getName());

        jdbcTemplate.update(sql, param);
    }

    @Override
    public void delete(Integer specialityId) {
        String sql = """
                DELETE
                FROM speciality
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", specialityId);

        jdbcTemplate.update(sql, param);
    }
}
