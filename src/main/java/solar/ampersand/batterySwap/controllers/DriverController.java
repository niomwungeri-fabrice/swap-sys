package solar.ampersand.batterySwap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solar.ampersand.batterySwap.exception.HttpResponseHandler;
import solar.ampersand.batterySwap.models.Driver;
import solar.ampersand.batterySwap.services.DriverService;

@RestController
@RequestMapping("v1")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/drivers")
    public ResponseEntity<?> createDriver(@RequestBody Driver driver) {
        try {
            driverService.createDriver(driver);
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("message", "Driver Created Successfully"),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpResponseHandler.responseHandler("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
