package solar.ampersand.batterySwap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.ampersand.batterySwap.dao.BatteryDAO;
import solar.ampersand.batterySwap.models.Battery;
import solar.ampersand.batterySwap.models.Station;

import java.util.UUID;

@Service
public class BatteryService {
    // Inject Database service to get access to CRUD methods without writing a single line of code
    @Autowired
    private BatteryDAO batteryDAO;

    public Battery createBattery(Battery battery){
        return batteryDAO.save(battery);
    }

    public Battery getOneBattery(String batteryId){
        return batteryDAO.getById(UUID.fromString(batteryId));
    }
}
