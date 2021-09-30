package solar.ampersand.batterySwap.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import solar.ampersand.batterySwap.models.RootModel;

@RestController
public class RootController {
    @GetMapping("/")
    public ResponseEntity<RootModel> route() {
        try {
            return new ResponseEntity<>( new RootModel("Welcome to Swap Sys V1."), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}