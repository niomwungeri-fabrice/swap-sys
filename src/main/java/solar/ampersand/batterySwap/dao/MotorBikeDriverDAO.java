package solar.ampersand.batterySwap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import solar.ampersand.batterySwap.models.MotorBikeDriver;

import java.util.UUID;

public interface MotorBikeDriverDAO extends JpaRepository<MotorBikeDriver, UUID> {
}
