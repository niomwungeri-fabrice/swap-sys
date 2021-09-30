package solar.ampersand.batterySwap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.ampersand.batterySwap.dao.StationDAO;
import solar.ampersand.batterySwap.models.Station;

import java.util.UUID;

@Service
public class StationService {
    @Autowired
    private StationDAO stationDAO;

    public Station createStation(Station station){
        return stationDAO.save(station);
    }

    public Station getOneStation(String stationId){
        return stationDAO.getById(UUID.fromString(stationId));
    }
}
