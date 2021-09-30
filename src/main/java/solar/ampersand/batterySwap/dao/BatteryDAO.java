package solar.ampersand.batterySwap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solar.ampersand.batterySwap.models.Battery;

import java.util.UUID;

@Repository
public interface BatteryDAO extends JpaRepository<Battery, UUID> {
    // inherit builtin CRUD and basic SQL functionalities
}
