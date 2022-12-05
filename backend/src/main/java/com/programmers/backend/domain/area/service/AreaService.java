package com.programmers.backend.domain.area.service;

import com.programmers.backend.domain.area.dto.AreaInsertRequestDto;
import com.programmers.backend.domain.area.entity.Area;
import com.programmers.backend.domain.area.repository.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public void insert(AreaInsertRequestDto areaInsertRequestDto) {
        Area area = new Area(areaInsertRequestDto);
        areaRepository.insert(area);
    }

    public List<Area> findAll() {
        return areaRepository.findAll();
    }
}
