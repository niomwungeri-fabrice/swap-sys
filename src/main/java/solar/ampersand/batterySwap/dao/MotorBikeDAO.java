package solar.ampersand.batterySwap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solar.ampersand.batterySwap.models.MotorBike;

import java.util.UUID;
@Repository
public interface MotorBikeDAO extends JpaRepository<MotorBike, UUID> {
}
