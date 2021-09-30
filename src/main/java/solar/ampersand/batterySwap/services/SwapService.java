package solar.ampersand.batterySwap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.ampersand.batterySwap.dao.OdoMeterDAO;
import solar.ampersand.batterySwap.dao.SwapDAO;
import solar.ampersand.batterySwap.models.MotorBike;
import solar.ampersand.batterySwap.models.OdoMeter;
import solar.ampersand.batterySwap.models.Swap;

@Service
public class SwapService {
    @Autowired
    private SwapDAO swapDAO;

    @Autowired
    private OdoMeterDAO odoMeterDAO;

    public void createSwap(Swap swap){
        swapDAO.save(swap);
    }
    public OdoMeter recordMileAge(MotorBike motorBike, Double currentReading){
        OdoMeter odoMeter = odoMeterDAO.findByMotorBikeId(motorBike.getMotorBikeId());
        // assign previous with current reading before changing it
        odoMeter.setPreviousReading(odoMeter.getCurrentReading());
        // assign current with current mileage +currentReading
        odoMeter.setCurrentReading(odoMeter.getCurrentReading()+currentReading);
        odoMeter.setMotorBike(motorBike);
        return odoMeterDAO.save(odoMeter);
    }


}
