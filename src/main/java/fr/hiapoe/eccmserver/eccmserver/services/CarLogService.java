package fr.hiapoe.eccmserver.eccmserver.services;

import fr.hiapoe.eccmserver.eccmserver.entities.CarLog;
import fr.hiapoe.eccmserver.eccmserver.repositories.CarLogRepository;
import fr.hiapoe.eccmserver.eccmserver.utils.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<CarLog> findAllByTripId(String tripId) {
        return this.carlogRepository.findAllByTripIdOrderByDeviceTime(tripId);
    }

    public List<String> findAllTripId() {
        return this.carlogRepository.getAllTripId();
    }

    public Coordinate findLastCoordinateForTripId(String tripId) {
        return this.carlogRepository.getLastCarLogWithCoordinatesByTripId(tripId)
                .map(carLog -> new Coordinate(carLog.getGpsLatitude(), carLog.getGpsLongitude())).orElse(null);
    }

    public Coordinate findFirstCoordinateForTripId(String tripId) {
        return this.carlogRepository.getFirstCarLogWithCoordinatesByTripId(tripId)
                .map(carLog -> new Coordinate(carLog.getGpsLatitude(), carLog.getGpsLongitude())).orElse(null);
    }
}
