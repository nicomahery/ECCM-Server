package fr.hiapoe.eccmserver.eccmserver.controllers;

import fr.hiapoe.eccmserver.eccmserver.dto.TripDTO;
import fr.hiapoe.eccmserver.eccmserver.services.CarLogService;
import fr.hiapoe.eccmserver.eccmserver.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/trips", produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class TripController {
    private final CarLogService carLogService;
    private final TripService tripService;

    @Autowired
    public TripController(CarLogService carLogService, TripService tripService) {
        this.carLogService = carLogService;
        this.tripService = tripService;
    }

    @GetMapping(value = "/ids")
    public ResponseEntity<List<String>> getTripIds() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.carLogService.findAllTripId());
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<TripDTO>> getTrips() {
        List<String> ids = this.carLogService.findAllTripId();
        List<TripDTO> tripDTOList = new ArrayList<>();
        for (String id : ids) {
            tripDTOList.add(this.tripService.createTripDTOFromCarLogs(id));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tripDTOList);
    }

    @GetMapping(value = "/pageable")
    public Page<TripDTO> getTripsPageable(Pageable pageable) {
        return this.tripService.findAllTrip(pageable);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getTripById(@PathVariable String id) {
        Optional<TripDTO> optionalTripDTO = this.tripService.findById(id);
        if (optionalTripDTO.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("no trip found for id: %s", id));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(optionalTripDTO.get());
    }

}
