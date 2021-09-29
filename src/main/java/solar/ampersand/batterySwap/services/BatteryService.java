package solar.ampersand.batterySwap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.ampersand.batterySwap.dao.BatteryDAO;
import solar.ampersand.batterySwap.models.Battery;

@Service
public class BatteryService {
    @Autowired
    private BatteryDAO batteryDAO;

    public void createBattery(Battery battery){
        batteryDAO.save(battery);
    }
}
