package fr.hiapoe.eccmserver.eccmserver.services;

import fr.hiapoe.eccmserver.eccmserver.entities.CarLog;
import fr.hiapoe.eccmserver.eccmserver.repositories.CarLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarLogService {
    private final CarLogRepository carlogRepository;

    @Autowired
    public CarLogService(CarLogRepository carlogRepository) {
        this.carlogRepository = carlogRepository;
    }

    public void save(CarLog carlog) {
        this.carlogRepository.save(carlog);
    }
}
