package com.example.train_station.service;

import java.util.List;
import java.util.Optional;
import com.example.train_station.entity.Train;
import com.example.train_station.repository.TrainRepository ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    @Autowired
    private TrainRepository repo;

    public List<Train> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public Train save(Train train) {

        return repo.save(train);
    }

    public Train get(Long id) {
        return repo.findById(id).get();
    }

    public Optional<Train> findById(long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
