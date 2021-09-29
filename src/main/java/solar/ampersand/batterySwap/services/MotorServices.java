package solar.ampersand.batterySwap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.ampersand.batterySwap.dao.MotorBikeDAO;
import solar.ampersand.batterySwap.dao.OdoMeterDAO;
import solar.ampersand.batterySwap.models.MotorBike;
import solar.ampersand.batterySwap.models.OdoMeter;

import java.util.ArrayList;
import java.util.List;

@Service
public class MotorServices {

    @Autowired
    MotorBikeDAO motorBikeDAO;

    @Autowired
    OdoMeterDAO odoMeterDAO;

    public void createBike(MotorBike motorBike){
        motorBikeDAO.save(motorBike);
        OdoMeter odoMeter = new OdoMeter();
        odoMeter.setMotorBike(motorBike);
        odoMeterDAO.save(odoMeter);
    }

    public List<MotorBike> getAllBikes() {
        List<MotorBike> motorBikes = motorBikeDAO.findAll();

        if (motorBikes.size() > 0) {
            return motorBikes;
        } else {
            return new ArrayList<MotorBike>();
        }
    }
}
