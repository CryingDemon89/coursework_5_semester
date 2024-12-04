package com.example.train_station.repository;

import java.util.List;
// Repository указывает, что класс используется для задания перечня необходимых работ по поиску,
// получению и сохранению данных.
import com.example.train_station.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface TrainRepository extends JpaRepository<Train, Long>{
    @Query("SELECT p FROM Train p WHERE CONCAT(p.name, ' ', p.car_num, ' ', p.compartment_num, ' ', " +
            "p.berth_num) LIKE %?1%")
    List<Train> search(String keyword);
}