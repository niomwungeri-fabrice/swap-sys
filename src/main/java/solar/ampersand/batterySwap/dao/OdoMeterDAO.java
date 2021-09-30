package solar.ampersand.batterySwap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import solar.ampersand.batterySwap.models.OdoMeter;

import java.util.UUID;

public interface OdoMeterDAO extends JpaRepository<OdoMeter, UUID> {
    // write custom queries on top of built-in methods
    @Query(value="select * from odo_meters a where a.motor_bike_id= :motorBikeId", nativeQuery=true)
    OdoMeter findByMotorBikeId(UUID motorBikeId);

}
