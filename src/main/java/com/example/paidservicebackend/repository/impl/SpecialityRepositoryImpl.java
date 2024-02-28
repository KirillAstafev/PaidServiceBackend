package com.example.paidservicebackend.repository.impl;

import com.example.paidservicebackend.model.Speciality;
import com.example.paidservicebackend.repository.SpecialityRepository;
import com.example.paidservicebackend.repository.impl.mapper.Mapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecialityRepositoryImpl implements SpecialityRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public SpecialityRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Speciality> findAll() {
        String sql = """
                SELECT id   AS speciality_id,
                       name AS speciality_name
                FROM speciality
                """;

        return jdbcTemplate.query(sql, Mapper.SPECIALITY_MAPPER);
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
