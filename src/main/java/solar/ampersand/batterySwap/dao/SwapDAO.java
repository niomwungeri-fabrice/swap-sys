package solar.ampersand.batterySwap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solar.ampersand.batterySwap.models.Swap;

import java.util.UUID;

@Repository
public interface SwapDAO extends JpaRepository<Swap, UUID> {
    // inherit builtin CRUD and basic SQL functionalities
}
