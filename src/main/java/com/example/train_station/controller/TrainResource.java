package com.example.train_station.controller;

import com.example.train_station.entity.Train;
import com.example.train_station.service.TrainService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trains")
public class TrainResource {
    private TrainService trainService;
    public TrainResource(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("/{id}")
    public Train findById(@PathVariable long id) {
        return trainService.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }

    @PostMapping
    public Train create(@RequestBody Train train) {
        return trainService.save(train);
    }
}
