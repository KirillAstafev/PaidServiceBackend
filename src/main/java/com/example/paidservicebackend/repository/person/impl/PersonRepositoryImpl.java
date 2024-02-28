package com.example.paidservicebackend.repository.person.impl;

import com.example.paidservicebackend.model.Person;
import com.example.paidservicebackend.repository.person.PersonRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final PersonMapper mapper;

    public PersonRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, PersonMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public Optional<Person> findBySnils(String snils) {
        String sql = """
                SELECT person.id           AS person_id,
                       person.first_name   AS person_first_name,
                       person.middle_name  AS person_middle_name,
                       person.last_name    AS person_last_name,
                       person.snils        AS person_snils,
                       person.phone_number AS person_phone_number
                FROM person
                WHERE snils = :snils
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("snils", snils);

        return jdbcTemplate.query(sql, param, mapper).stream().findAny();
    }

    @Override
    public Integer save(Person person) {
        String sql = """
                INSERT INTO person (first_name, middle_name, last_name, snils, phone_number)
                VALUES (:firstName, :middleName, :lastName, :snils, :phoneNumber)
                RETURNING id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("firstName", person.getFirstName())
                .addValue("middleName", person.getMiddleName())
                .addValue("lastName", person.getLastName())
                .addValue("snils", person.getSnils())
                .addValue("phoneNumber", person.getPhoneNumber());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, keyHolder);

        return keyHolder.getKeyAs(Integer.class);
    }

    @Override
    public void update(Person person) {
        String sql = """
                UPDATE person
                SET first_name   = :firstName,
                    middle_name  = :middleName,
                    last_name    = :lastName,
                    snils        = :snils,
                    phone_number = :phoneNumber
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", person.getId())
                .addValue("firstName", person.getFirstName())
                .addValue("middleName", person.getMiddleName())
                .addValue("lastName", person.getLastName())
                .addValue("snils", person.getSnils())
                .addValue("phoneNumber", person.getPhoneNumber());

        jdbcTemplate.update(sql, param);
    }

    @Override
    public void delete(Integer personId) {
        String sql = """
                DELETE FROM person
                WHERE id = :id
                """;

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", personId);

        jdbcTemplate.update(sql, param);
    }
}
