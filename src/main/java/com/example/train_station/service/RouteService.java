package com.example.train_station.service;

import java.util.List;
import java.util.Optional;
import com.example.train_station.entity.Route;
import com.example.train_station.repository.RouteRepository ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRepository repo;
    public List<Route> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public List<Route> listFiltered(long scheduleid) {
        return repo.findByScheduleid(scheduleid);
    }

    public Route save(Route route) {
        return repo.save(route);
    }

    public Route get(Long id) {
        return repo.findById(id).get();
    }
    public Optional<Route> findById(long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
