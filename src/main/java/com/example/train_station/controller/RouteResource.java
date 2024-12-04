package com.example.train_station.controller;

import com.example.train_station.entity.Route;
import com.example.train_station.service.RouteService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/route")
public class RouteResource {
    private RouteService routeService;
    public RouteResource(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/{id}")
    public Route findById(@PathVariable long id) {
        return routeService.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }

    @PostMapping
    public Route create(@RequestBody Route route) {
        return routeService.save(route);
    }
}
