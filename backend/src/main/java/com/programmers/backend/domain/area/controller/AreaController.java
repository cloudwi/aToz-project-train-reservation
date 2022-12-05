package com.programmers.backend.domain.area.controller;

import com.programmers.backend.domain.area.dto.AreaFindAllResponseDto;
import com.programmers.backend.domain.area.dto.AreaInsertRequestDto;
import com.programmers.backend.domain.area.entity.Area;
import com.programmers.backend.domain.area.service.AreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/area")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping()
    public void insert(@RequestBody AreaInsertRequestDto areaInsertRequestDto) {
        areaService.insert(areaInsertRequestDto);
    }

    @GetMapping()
    public ResponseEntity<List<AreaFindAllResponseDto>> findAll() {
        List<Area> areas = areaService.findAll();
        List<AreaFindAllResponseDto> areaFindAllResponseDtos = new ArrayList<>();
        areas.forEach(area -> areaFindAllResponseDtos.add(new AreaFindAllResponseDto(area)));
        return ResponseEntity.ok(areaFindAllResponseDtos);
    }
}
