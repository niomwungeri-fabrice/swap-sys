package solar.ampersand.batterySwap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solar.ampersand.batterySwap.models.Station;

import java.util.UUID;

@Repository
public interface StationDAO extends JpaRepository<Station, UUID> {
    // inherit builtin CRUD and basic SQL functionalities
}
