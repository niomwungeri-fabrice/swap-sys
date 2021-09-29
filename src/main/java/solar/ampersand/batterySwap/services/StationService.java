package solar.ampersand.batterySwap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.ampersand.batterySwap.dao.StationDAO;
import solar.ampersand.batterySwap.models.Station;

@Service
public class StationService {
    @Autowired
    private StationDAO stationDAO;

    public void createStation(Station station){
        stationDAO.save(station);
    }
}
