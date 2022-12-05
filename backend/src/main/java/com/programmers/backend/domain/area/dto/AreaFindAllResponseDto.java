package com.programmers.backend.domain.area.dto;

import com.programmers.backend.domain.area.entity.Area;

public class AreaFindAllResponseDto {
    private final int id;
    private final String name;

    public AreaFindAllResponseDto(Area area) {
        this.id = area.getId();
        this.name = area.getName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
