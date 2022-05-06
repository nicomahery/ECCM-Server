package fr.hiapoe.eccmserver.eccmserver.controllers;

import fr.hiapoe.eccmserver.eccmserver.dto.CarLogUploadDTO;
import fr.hiapoe.eccmserver.eccmserver.services.TripUploadService;
import fr.hiapoe.eccmserver.eccmserver.utils.TripImportSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequestMapping(value = "/api/carloguploads", produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class CarLogUploadController {

    private final TripUploadService carLogService;

    @Autowired
    public CarLogUploadController(TripUploadService carLogService) {
        this.carLogService = carLogService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> newCarLogUpload(@RequestBody CarLogUploadDTO carLogUploadDTO) {
        TripImportSummary tripImportSummary = this.carLogService.processCarLogUpload(carLogUploadDTO);
        if (!Objects.isNull(tripImportSummary.getTripId())) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(tripImportSummary);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body("Unable to create Car Log");
    }

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("All good");
    }
}
