package com.programmers.backend.domain.area.repository.impl;

import com.programmers.backend.domain.area.entity.Area;
import com.programmers.backend.domain.area.repository.AreaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class AreaRepositoryImpl implements AreaRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AreaRepositoryImpl(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Area> findAll() {
        String sql = "SELECT * FROM area";
        return namedParameterJdbcTemplate.query(sql, areaRowMapper);
    }

    @Override
    public void insert(Area area) {
        String sql = "INSERT INTO area (name) VALUES (:name)";
        int update = namedParameterJdbcTemplate.update(sql, toParamMap(area));

        if (update != 1) {
            throw new RuntimeException("Area 데이터베이스에 insert 되지 못했습니다.");
        }
    }

    @Override
    public Optional<Area> findById(int id) {
        String sql = "SELECT * FROM area WHERE id = :id";
        try {
            return Optional.of(namedParameterJdbcTemplate.queryForObject(sql, Collections.singletonMap("id", id), areaRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private static final RowMapper<Area> areaRowMapper = (resultSet, i) -> {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        return new Area(id, name);
    };

    private static Map<String, Object> toParamMap(Area area) {
        HashMap<String, Object> paramMap = new HashMap<>();

        paramMap.put("name", area.getName());

        return paramMap;
    }
}
