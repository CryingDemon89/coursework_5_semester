package com.example.train_station.repository;

import com.example.train_station.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
// JpaRepository – интерфейс фреймворка Spring Data, предоставляющий набор стандартных методов JPA для работы с БД.
import org.springframework.data.jpa.repository.Query; // аннотация sql запроса
import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long>{
    @Query("SELECT p FROM Route p WHERE CONCAT(p.scheduleid, ' ', p.station, ' ', p.arr_time, ' ', " +
            "p.stop, ' ', p.dep_time) LIKE %?1%")
    List<Route> search(String keyword);
    List<Route> findByScheduleid(long scheduleid);
}