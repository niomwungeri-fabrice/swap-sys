package solar.ampersand.batterySwap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import solar.ampersand.batterySwap.models.OdoMeter;

import java.util.UUID;

public interface OdoMeterDAO extends JpaRepository<OdoMeter, UUID> {
    @Query("SELECT o FROM OdoMeter o WHERE o.motorBike.motorBikeId=?1")
    public OdoMeter findByMotorBikeId(UUID motorBikeId);
}
