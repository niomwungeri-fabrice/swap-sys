package solar.ampersand.batterySwap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solar.ampersand.batterySwap.exceptions.HttpResponseHandler;
import solar.ampersand.batterySwap.helpers.GenericResponse;
import solar.ampersand.batterySwap.models.Station;
import solar.ampersand.batterySwap.services.StationService;

@RestController
@RequestMapping("v1")
public class StationController {

    @Autowired
    private StationService stationService;

    @PostMapping("/stations")
    public ResponseEntity<?> createStation(@RequestBody Station station) {
        try {
            return new ResponseEntity<>(new GenericResponse("Station Created Successfully", stationService.createStation(station)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
