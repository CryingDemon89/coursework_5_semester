package com.example.train_station.repository;

import com.example.train_station.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    @Query("SELECT p FROM Schedule p WHERE CONCAT(p.arr_time, ' ', p.name, ' ', p.path, ' ', " +
            "p.train, ' ', p.driver) LIKE %?1%")
    List<Schedule> search(String keyword);
}