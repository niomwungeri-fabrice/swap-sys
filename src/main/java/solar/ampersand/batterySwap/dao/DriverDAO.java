package solar.ampersand.batterySwap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solar.ampersand.batterySwap.models.Driver;

import java.util.UUID;

@Repository
public interface DriverDAO extends JpaRepository<Driver, UUID> {
    // inherit builtin CRUD and basic SQL functionalities
}
