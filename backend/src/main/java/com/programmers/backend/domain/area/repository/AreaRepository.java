package com.programmers.backend.domain.area.repository;

import com.programmers.backend.domain.area.entity.Area;

import java.util.List;
import java.util.Optional;

public interface AreaRepository {
    List<Area> findAll();
    void insert(Area area);

    Optional<Area> findById(int departure);
}
