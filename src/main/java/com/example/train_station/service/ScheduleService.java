package com.example.train_station.service;

import java.util.List;
import java.util.Optional;
import com.example.train_station.entity.Schedule;
import com.example.train_station.repository.ScheduleRepository ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository repo;

    public List<Schedule> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public Schedule save(Schedule schedule) {

        return repo.save(schedule);
    }

    public Schedule get(Long id) {
        return repo.findById(id).get();
    }
    public Optional<Schedule> findById(long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
