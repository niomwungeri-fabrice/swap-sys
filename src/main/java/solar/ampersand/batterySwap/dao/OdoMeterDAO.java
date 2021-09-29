package solar.ampersand.batterySwap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solar.ampersand.batterySwap.models.OdoMeter;

import java.util.UUID;

@Repository
public interface OdoMeterDAO extends JpaRepository<OdoMeter, UUID> {
}
