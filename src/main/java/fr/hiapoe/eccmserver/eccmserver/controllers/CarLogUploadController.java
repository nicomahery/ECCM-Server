package fr.hiapoe.eccmserver.eccmserver.controllers;

import fr.hiapoe.eccmserver.eccmserver.dto.CarLogUploadDTO;
import fr.hiapoe.eccmserver.eccmserver.services.CarLogUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/carloguploads", produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class CarLogUploadController {

    private final CarLogUploadService carLogService;

    @Autowired
    public CarLogUploadController(CarLogUploadService carLogService) {
        this.carLogService = carLogService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> newCarLogUpload(@RequestBody CarLogUploadDTO carLogUploadDTO) {
        if (this.carLogService.processCarLogUpload(carLogUploadDTO)) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body("Unable to create Car Log");
    }
}
