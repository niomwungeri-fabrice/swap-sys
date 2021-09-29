package solar.ampersand.batterySwap.controllers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solar.ampersand.batterySwap.exception.HttpResponseHandler;
import solar.ampersand.batterySwap.models.MotorBike;
import solar.ampersand.batterySwap.services.AssignMotorBikeService;
import solar.ampersand.batterySwap.services.MotorService;

@RestController
@RequestMapping("v1")
public class MotorBikeController {

    @Autowired
    private MotorService motorService;

    @Autowired
    private AssignMotorBikeService assignBatteryToMotorBike;

    @GetMapping("/bikes")
    public ResponseEntity<?> getAllBikes() {
        try {
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("data", motorService.getAllBikes()),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bikes")
    public ResponseEntity<?> createMotorBike(@RequestBody String motorBike) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(motorBike);
            String name = (String) json.get("name");
            String model = (String) json.get("model");
            MotorBike bike = new MotorBike();
            bike.setModel(model);
            bike.setName(name);
            motorService.createBike(bike);
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("message", "Motor Vehicle Created Successfully"),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bikes/assign")
    public ResponseEntity<?> assignMotorBikeToDriver(@RequestBody String motorBikeBattery) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(motorBikeBattery);
            String driverId = (String) json.get("driverId");
            String motorBikeId = (String) json.get("motorBikeId");
            assignBatteryToMotorBike.assignMotoBikeToDrive(driverId, motorBikeId);
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("message", "Driver ["+driverId+"] Assigned to ["+motorBikeId+"] Successfully"),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
