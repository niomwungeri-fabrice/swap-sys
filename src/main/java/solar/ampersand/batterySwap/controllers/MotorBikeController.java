package solar.ampersand.batterySwap.controllers;

import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solar.ampersand.batterySwap.exception.HttpResponseHandler;
import solar.ampersand.batterySwap.models.MotorBike;
import solar.ampersand.batterySwap.models.OdoMeter;
import solar.ampersand.batterySwap.services.MotorServices;

@RestController
@RequestMapping("v1")
public class MotorBikeController {

    @Autowired
    MotorServices motorServices;


    @GetMapping("/motors")
    public ResponseEntity<?> getAllBikes() {
        try {
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("data", motorServices.getAllBikes()),
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/motors")
    public ResponseEntity<?> createMotorBike(String motorBike) {
        try {

            System.out.println(motorBike);
//            motorServices.createBike(motorBike);

            return new ResponseEntity<>(HttpResponseHandler.responseHandler("message", "Motor Vehicle Created Successfully"),
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
