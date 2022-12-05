package com.programmers.backend.domain.area.entity;

import com.programmers.backend.domain.area.dto.AreaInsertRequestDto;

public class Area {
    private int id;
    private String name;

    public Area(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Area(AreaInsertRequestDto areaInsertRequestDto) {
        this.name = areaInsertRequestDto.name();
    }

    public Area(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
