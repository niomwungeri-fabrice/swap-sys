package solar.ampersand.batterySwap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.ampersand.batterySwap.dao.BatteryDAO;
import solar.ampersand.batterySwap.dao.MotorBikeBatteryDAO;
import solar.ampersand.batterySwap.dao.MotorBikeDAO;
import solar.ampersand.batterySwap.models.Battery;
import solar.ampersand.batterySwap.models.MotorBike;
import solar.ampersand.batterySwap.models.MotorBikeBattery;

import java.util.UUID;

@Service
public class AssignBatteryService {
    @Autowired
    private MotorBikeDAO motorBikeDAO;
    @Autowired
    private BatteryDAO batteryDAO;
    @Autowired
    private MotorBikeBatteryDAO motorBikeBatteryDAO;

    // Assign battery to a moto before being used
    public MotorBikeBattery assignBatteryToMotorBike(String batteryId, String motorBikeId){
        try {
            // Get battery instance
            Battery battery = batteryDAO.getById(UUID.fromString(batteryId));
            // Get motorBike instance
            MotorBike motorBike = motorBikeDAO.getById(UUID.fromString(motorBikeId));
            MotorBikeBattery motorBikeBattery = new MotorBikeBattery();
            //assign retrieved instance to MotorBikeBattery class
            motorBikeBattery.setBattery(battery);
            motorBikeBattery.setMotorBike(motorBike);
            // Assign battery to a moto
           return  motorBikeBatteryDAO.save(motorBikeBattery);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
