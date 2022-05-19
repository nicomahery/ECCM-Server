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

    public TripDTO createTripFromCarLogs(String tripId) {
        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(tripId);
        tripDTO.setStartTime(this.carLogService.getFirstDeviceTimeForTripId(tripId));
        tripDTO.setEndTime(this.carLogService.getLastDeviceTimeForTripId(tripId));
        tripDTO.setStartCoordinate(this.carLogService.findFirstCoordinateForTripId(tripDTO.getId()));
        tripDTO.setEndCoordinate(this.carLogService.findLastCoordinateForTripId(tripDTO.getId()));
        return tripDTO;
    }
}
