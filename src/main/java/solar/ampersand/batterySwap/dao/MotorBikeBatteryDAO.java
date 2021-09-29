package solar.ampersand.batterySwap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import solar.ampersand.batterySwap.models.MotorBike;
import solar.ampersand.batterySwap.models.MotorBikeBattery;

import java.util.UUID;

@Repository
public interface MotorBikeBatteryDAO extends JpaRepository<MotorBikeBattery, UUID> {

}
