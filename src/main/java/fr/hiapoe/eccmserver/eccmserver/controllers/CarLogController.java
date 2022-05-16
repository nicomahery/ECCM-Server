package fr.hiapoe.eccmserver.eccmserver.controllers;

import fr.hiapoe.eccmserver.eccmserver.entities.CarLog;
import fr.hiapoe.eccmserver.eccmserver.services.CarLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/carlogs", produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class CarLogController {

    private final CarLogService carLogService;

    @Autowired
    public CarLogController(CarLogService carLogService) {
        this.carLogService = carLogService;
    }

    @GetMapping(value = "/findByTripId/{id}")
    public ResponseEntity<Object> findByTripId(@PathVariable String id) {
        List<CarLog> carLogs = this.carLogService.findAllByTripId(id);
        if (carLogs.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("No carLogs found for tripId:%s", id));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(carLogs);
    }
}
