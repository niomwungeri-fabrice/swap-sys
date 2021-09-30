package solar.ampersand.batterySwap.controllers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solar.ampersand.batterySwap.exceptions.HttpResponseHandler;
import solar.ampersand.batterySwap.helpers.CustomResponse;
import solar.ampersand.batterySwap.helpers.GenericResponse;
import solar.ampersand.batterySwap.models.*;
import solar.ampersand.batterySwap.services.*;

import java.util.UUID;

@RestController
@RequestMapping("v1")
public class SwapController {

    //################ Accessing Database Service ################
    @Autowired
    private BatteryService batteryService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private StationService stationService;

    @Autowired
    private SwapService swapService;

    @Autowired
    private AssignMotorBikeService assignMotorBikeService;

    @Autowired
    private AssignMotorBikeService assignMotorBikeToDriver;


    //################ Accessing Database Service ################

    @PostMapping("/swaps")
    @Transactional
    public ResponseEntity<?> swapping(@RequestBody String swapRequest) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(swapRequest);
            // get Driver who's swapping
            String driverId = (String) json.get("driverId");
            Driver driver = driverService.getOneDriver(driverId);
            // get battery to be replaced
            Battery returnedBattery = batteryService.getOneBattery((String) json.get("returnedBatteryId"));
            // get out station battery
            Battery takenBattery = batteryService.getOneBattery((String) json.get("takenBatteryId"));
            // get Station where swapping is taking place
            Station station = stationService.getOneStation((String) json.get("stationId"));

            // get the battery life of outing battery
            String batteryOutLevel = (String) json.get("batteryOutLevel");
            // get battery life of what is being taken(recharged)
            String batteryInLevel = (String) json.get("batteryInLevel");

            // get current Reading
            String currentMileAge  = (String) json.get("currentMileAge");

            MotorBike motorBike = driver.getMotorBikeDriver().getMotorBike();

            // Construct swap instance
            Swap swap = new Swap();

            swap.setDriver(driver);
            swap.setReturnedBattery(returnedBattery);
            swap.setTakenBattery(takenBattery);
            swap.setStation(station);
            swap.setBatteryInLevel(Double.valueOf(batteryInLevel));
            swap.setBatteryOutLevel(Double.valueOf(batteryOutLevel));
            swapService.createSwap(swap);

            // create battery assigned to
            assignMotorBikeService.assignMotoBikeToDrive(driverId, motorBike.getMotorBikeId().toString());
            // update odo meter
            OdoMeter odoMeter = swapService.recordMileAge(motorBike, Double.valueOf(currentMileAge));


            return new ResponseEntity<>(new CustomResponse("Battery Swapped Successfully", odoMeter, odoMeter.getCurrentReading() - odoMeter.getPreviousReading()),
                    HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
