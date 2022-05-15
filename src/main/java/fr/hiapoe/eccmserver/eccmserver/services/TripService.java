package fr.hiapoe.eccmserver.eccmserver.services;

import fr.hiapoe.eccmserver.eccmserver.dto.TripDTO;
import fr.hiapoe.eccmserver.eccmserver.entities.CarLog;
import fr.hiapoe.eccmserver.eccmserver.utils.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TripService {
    private final CarLogService carLogService;

    @Autowired
    public TripService(CarLogService carLogService) {
        this.carLogService = carLogService;
    }

    public TripDTO createTripFromCarLogs(List<CarLog> carLogs) {
        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(carLogs.get(0).getTripId());
        tripDTO.setStartTime(carLogs.get(0).getDeviceTime());
        tripDTO.setStartTime(carLogs.get(carLogs.size()-1).getDeviceTime());
        tripDTO.setStartCoordinate(this.carLogService.findFirstCoordinateForTripId(tripDTO.getId()));
        tripDTO.setEndCoordinate(this.carLogService.findLastCoordinateForTripId(tripDTO.getId()));
        return tripDTO;
    }
}
