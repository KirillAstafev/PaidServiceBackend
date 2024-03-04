package com.example.paidservicebackend.repository.service.impl;

import com.example.paidservicebackend.model.MedicalService;
import com.example.paidservicebackend.repository.service.MedicalServiceRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalServiceRepositoryImpl implements MedicalServiceRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MedicalServiceMapper mapper;

    public MedicalServiceRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, MedicalServiceMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public List<MedicalService> findAll() {
        String sql = """
                SELECT medical_service.id    AS service_id,
                       medical_service.name  AS service_name,
                       medical_service.price AS service_price
                FROM medical_service
                """;

        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Integer save(MedicalService service) {
        String sql = """
                INSERT INTO medical_service (name, price)
                VALUES (:name, :price)
                RETURNING id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", service.getName())
                .addValue("price", service.getPrice());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, keyHolder);

        return keyHolder.getKeyAs(Integer.class);
    }

    @Override
    public void update(MedicalService service) {
        String sql = """
                UPDATE medical_service
                SET name  = :name,
                    price = :price
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", service.getId())
                .addValue("name", service.getName())
                .addValue("price", service.getPrice());

        jdbcTemplate.update(sql, param);
    }

    @Override
    public void delete(Integer serviceId) {
        String sql = """
                DELETE
                FROM medical_service
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", serviceId);

        jdbcTemplate.update(sql, param);
    }
}
