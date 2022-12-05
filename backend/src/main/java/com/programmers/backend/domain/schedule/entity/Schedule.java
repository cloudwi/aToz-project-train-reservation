package com.programmers.backend.domain.schedule.entity;

import com.programmers.backend.domain.area.entity.Area;

import java.time.LocalDateTime;

public class Schedule {
    private long id;
    private Area departure;
    private LocalDateTime departureTime;
    private Area arrival;
    private LocalDateTime arrivalTime;
    private final int carriage;
    private final LocalDateTime createdAt;

    public Schedule(long id, Area departure, LocalDateTime departureTime, Area arrival, LocalDateTime arrivalTime, int carriage, LocalDateTime createdAt) {
        this.id = id;
        this.departure = departure;
        this.departureTime = departureTime;
        this.arrival = arrival;
        this.arrivalTime = arrivalTime;
        this.carriage = carriage;
        this.createdAt = createdAt;
    }

    public Schedule(Area departure, LocalDateTime departureTime, Area arrival, LocalDateTime arrivalTime, int carriage) {
        this.departure = departure;
        this.departureTime = departureTime;
        this.arrival = arrival;
        this.arrivalTime = arrivalTime;
        this.carriage = carriage;
        this.createdAt = LocalDateTime.now().withNano(0);
    }

    public long getId() {
        return id;
    }

    public Area getDeparture() {
        return departure;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public Area getArrival() {
        return arrival;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public int getCarriage() {
        return carriage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
