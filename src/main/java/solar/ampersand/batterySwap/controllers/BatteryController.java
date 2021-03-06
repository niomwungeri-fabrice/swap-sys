package solar.ampersand.batterySwap.controllers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solar.ampersand.batterySwap.exceptions.HttpResponseHandler;
import solar.ampersand.batterySwap.helpers.GenericResponse;
import solar.ampersand.batterySwap.models.Battery;
import solar.ampersand.batterySwap.services.AssignBatteryService;
import solar.ampersand.batterySwap.services.BatteryService;


@RestController
@RequestMapping("v1")
public class BatteryController {

    @Autowired
    private BatteryService batteryService;

    @Autowired
    private AssignBatteryService assignBatteryService;

    @PostMapping("/batteries")
    public ResponseEntity<?> createBattery(@RequestBody Battery battery) {
        try {
            return new ResponseEntity<>(new GenericResponse("Battery Created Successfully", batteryService.createBattery(battery)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/batteries/assign")
    public ResponseEntity<?> assignBatteryToMotorBike(@RequestBody String motorBikeBattery) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(motorBikeBattery);
            String batteryId = (String) json.get("batteryId");
            String motorBikeId = (String) json.get("motorBikeId");
            return new ResponseEntity<>(new GenericResponse("Battery [" + batteryId + "] Assigned to MotorBike [" + motorBikeId + "] Successfully", assignBatteryService.assignBatteryToMotorBike(batteryId, motorBikeId)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
