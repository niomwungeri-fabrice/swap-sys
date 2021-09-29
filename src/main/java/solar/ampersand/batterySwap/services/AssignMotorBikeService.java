package solar.ampersand.batterySwap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.ampersand.batterySwap.dao.*;
import solar.ampersand.batterySwap.models.*;

import java.util.UUID;

@Service
public class AssignMotorBikeService {
    @Autowired
    private MotorBikeDAO motorBikeDAO;
    @Autowired
    private DriverDAO driverDAO;
    @Autowired
    private MotorBikeDriverDAO motorBikeDriverDAO;

    // Assign MotorBike to A driver
    public void assignMotoBikeToDrive(String driverId, String motorBikeId){
        try {
            // Get Driver instance
            Driver driver = driverDAO.getById(UUID.fromString(driverId));
            // Get motorBike instance
            MotorBike motorBike = motorBikeDAO.getById(UUID.fromString(motorBikeId));
            MotorBikeDriver motorBikeDriver = new MotorBikeDriver();
            //assign retrieved instance to MotorBikeDriver class
            motorBikeDriver.setDriver(driver);
            motorBikeDriver.setMotorBike(motorBike);
            // Assign driver to a motorBike
            motorBikeDriverDAO.save(motorBikeDriver);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
