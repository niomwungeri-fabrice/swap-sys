package solar.ampersand.batterySwap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.ampersand.batterySwap.dao.DriverDAO;
import solar.ampersand.batterySwap.models.Driver;
import solar.ampersand.batterySwap.models.Station;

import java.util.UUID;

@Service
public class DriverService {
    @Autowired
    private DriverDAO driverDAO;

    public Driver createDriver(Driver driver){
        return driverDAO.save(driver);
    }
    public Driver getOneDriver(String driverId){
        return driverDAO.getById(UUID.fromString(driverId));
    }
}
