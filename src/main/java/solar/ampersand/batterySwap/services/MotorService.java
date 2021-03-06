package solar.ampersand.batterySwap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.ampersand.batterySwap.dao.MotorBikeDAO;
import solar.ampersand.batterySwap.dao.OdoMeterDAO;
import solar.ampersand.batterySwap.models.MotorBike;
import solar.ampersand.batterySwap.models.OdoMeter;

import java.util.List;

@Service
public class MotorService {

    @Autowired
    MotorBikeDAO motorBikeDAO;

    @Autowired
    OdoMeterDAO odoMeterDAO;

    public OdoMeter createBike(MotorBike motorBike){
        motorBikeDAO.save(motorBike);
        OdoMeter odoMeter = new OdoMeter();
        odoMeter.setMotorBike(motorBike);
        return odoMeterDAO.save(odoMeter);
    }



    public List<MotorBike> getAllBikes() {
       return motorBikeDAO.findAll();
    }
}
