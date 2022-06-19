package fr.hiapoe.eccmserver.eccmserver.services;

import fr.hiapoe.eccmserver.eccmserver.dto.TripDTO;
import fr.hiapoe.eccmserver.eccmserver.entities.Trip;
import fr.hiapoe.eccmserver.eccmserver.repositories.TripRepository;
import fr.hiapoe.eccmserver.eccmserver.utils.Coordinate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TripService {
    private final CarLogService carLogService;
    private final TripRepository tripRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TripService(CarLogService carLogService, TripRepository tripRepository, ModelMapper modelMapper) {
        this.carLogService = carLogService;
        this.tripRepository = tripRepository;
        this.modelMapper = modelMapper;
    }

    public void generateMissingTrips() {
        List<String> tripIds = this.findAllId();
        List<String> ids = this.carLogService.findAllTripId();
        for (String id: ids) {
            if (! tripIds.contains(id)) {
                this.saveByTripId(id);
            }
        }
    }

    public Page<TripDTO> findAllTrip(Pageable pageable) {
        return this.tripRepository.findAll(pageable).map(this::convertEntityToDTO);
    }

    public List<String> findAllId() {
        return this.tripRepository.getAllId();
    }

    public TripDTO createTripDTOFromCarLogs(String tripId) {
        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(tripId);
        tripDTO.setStartTime(this.carLogService.getFirstDeviceTimeForTripId(tripId));
        tripDTO.setEndTime(this.carLogService.getLastDeviceTimeForTripId(tripId));
        tripDTO.setStartCoordinate(this.carLogService.findFirstCoordinateForTripId(tripDTO.getId()).orElse(null));
        tripDTO.setEndCoordinate(this.carLogService.findLastCoordinateForTripId(tripDTO.getId()).orElse(null));
        return tripDTO;
    }

    public void save(Trip trip) {
        this.tripRepository.save(trip);
    }

    public void saveByTripId(String tripId) {
        Coordinate startCoordinate = this.carLogService.findFirstCoordinateForTripId(tripId).orElse(new Coordinate(null, null));
        Coordinate endCoordinate = this.carLogService.findLastCoordinateForTripId(tripId).orElse(new Coordinate(null, null));
        Trip trip = new Trip();
        trip.setId(tripId);
        trip.setStartTime(this.carLogService.getFirstDeviceTimeForTripId(tripId));
        trip.setEndTime(this.carLogService.getLastDeviceTimeForTripId(tripId));
        trip.setStartLatitude(startCoordinate.getLatitude());
        trip.setStartLongitude(startCoordinate.getLongitude());
        trip.setEndLatitude(endCoordinate.getLatitude());
        trip.setEndLongitude(endCoordinate.getLongitude());
        this.save(trip);
    }

    public TripDTO convertEntityToDTO(Trip entity) {
        TripDTO dto = this.modelMapper.map(entity, TripDTO.class);
        dto.setStartCoordinate(new Coordinate(entity.getStartLatitude(), entity.getStartLongitude()));
        dto.setEndCoordinate(new Coordinate(entity.getEndLatitude(), entity.getEndLongitude()));
        return dto;
    }
}
