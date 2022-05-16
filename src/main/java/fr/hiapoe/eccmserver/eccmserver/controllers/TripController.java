package fr.hiapoe.eccmserver.eccmserver.controllers;

import fr.hiapoe.eccmserver.eccmserver.dto.TripDTO;
import fr.hiapoe.eccmserver.eccmserver.entities.CarLog;
import fr.hiapoe.eccmserver.eccmserver.services.CarLogService;
import fr.hiapoe.eccmserver.eccmserver.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
            tripDTOList.add(this.tripService.createTripFromCarLogs(this.carLogService.findAllByTripId(id)));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tripDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TripDTO> getTripById(@PathVariable String id) {
        List<CarLog> carLogs = this.carLogService.findAllByTripId(id);
        TripDTO tripDTO = this.tripService.createTripFromCarLogs(carLogs);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tripDTO);
    }

}
