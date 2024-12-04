package com.example.train_station.controller;

import com.example.train_station.entity.Schedule;
import com.example.train_station.service.ScheduleService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/schedule")
public class AppResource {
    private ScheduleService scheduleService;
    public AppResource(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{id}")
    public Schedule findById(@PathVariable long id) {
        return scheduleService.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }

    @PostMapping
    public Schedule create(@RequestBody Schedule schedule) {
        return scheduleService.save(schedule);
    }
}
