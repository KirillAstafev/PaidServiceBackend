package com.example.paidservicebackend.repository.impl;

import com.example.paidservicebackend.model.Diagnosis;
import com.example.paidservicebackend.repository.DiagnosisRepository;
import com.example.paidservicebackend.repository.impl.mapper.Mapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class DiagnosisRepositoryImpl implements DiagnosisRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public DiagnosisRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Diagnosis> findAll() {
        String sql = """
                SELECT id   AS diagnosis_id,
                       code AS diagnosis_code,
                       name AS diagnosis_name
                FROM diagnosis
                """;

        return jdbcTemplate.query(sql, Mapper.DIAGNOSIS_MAPPER);
    }

    @Override
    public Integer save(Diagnosis diagnosis) {
        String sql = """
                INSERT INTO diagnosis (code, name)
                VALUES (:code, :name)
                RETURNING id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("code", diagnosis.getCode())
                .addValue("name", diagnosis.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, keyHolder);

        return keyHolder.getKeyAs(Integer.class);
    }

    @Override
    public void update(Diagnosis diagnosis) {
        String sql = """
                UPDATE diagnosis
                SET code = :code,
                    name = :name
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("code", diagnosis.getCode())
                .addValue("name", diagnosis.getName())
                .addValue("id", diagnosis.getId());

        jdbcTemplate.update(sql, param);
    }

    @Override
    public void delete(Integer diagnosisId) {
        String sql = """
                DELETE
                FROM diagnosis
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", diagnosisId, Types.INTEGER);

        jdbcTemplate.update(sql, param);
    }
}
