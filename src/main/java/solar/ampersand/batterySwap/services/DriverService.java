package solar.ampersand.batterySwap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.ampersand.batterySwap.dao.DriverDAO;
import solar.ampersand.batterySwap.models.Driver;

@Service
public class DriverService {
    @Autowired
    private DriverDAO driverDAO;

    public void createDriver(Driver driver){
        driverDAO.save(driver);
    }
}
