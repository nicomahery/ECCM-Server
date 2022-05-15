package fr.hiapoe.eccmserver.eccmserver.controllers;

import fr.hiapoe.eccmserver.eccmserver.dto.CarLogUploadDTO;
import fr.hiapoe.eccmserver.eccmserver.services.TripUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/api/carloguploads", produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class CarLogUploadController {

    private final TripUploadService tripUploadService;

    @Autowired
    public CarLogUploadController(TripUploadService tripUploadService) {
        this.tripUploadService = tripUploadService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> newCarLogUpload(@RequestBody CarLogUploadDTO carLogUploadDTO) {
        this.tripUploadService.saveTripFromUpload(carLogUploadDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(String.format("TRIP %s SAVE RECEIVED", carLogUploadDTO.getObjectLocation()));
    }

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("All good");
    }
}
