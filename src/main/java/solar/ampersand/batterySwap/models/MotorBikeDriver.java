package solar.ampersand.batterySwap.models;

import solar.ampersand.batterySwap.generics.GenericModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="motorbike_drivers")
public class MotorBikeDriver extends GenericModel {
    @Id
    @Column(name = "motor_drivers_id")
    protected UUID motorDriverId = UUID.randomUUID();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "motor_bike_id")
    private MotorBike motorBike;


    public UUID getMotorDriverId() {
        return motorDriverId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public MotorBike getMotorBike() {
        return motorBike;
    }

    public void setMotorBike(MotorBike motorBike) {
        this.motorBike = motorBike;
    }
}
