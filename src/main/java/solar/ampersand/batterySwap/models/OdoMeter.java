package solar.ampersand.batterySwap.models;

import solar.ampersand.batterySwap.generics.GenericModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "odo_meters")
public class OdoMeter extends GenericModel {
    @Id
    @Column(name = "odo_meter_id")
    protected UUID odoMeterId = UUID.randomUUID();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "motor_bike_id")
    private MotorBike motorBike;

    @Column
    private double currentReading = 0f;
    @Column
    private double previousReading = 0f;

    public UUID getOdoMeterId() {
        return odoMeterId;
    }

    public MotorBike getMotorBike() {
        return motorBike;
    }

    public void setMotorBike(MotorBike motorBike) {
        this.motorBike = motorBike;
    }

    public double getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(double currentReading) {
        this.currentReading = currentReading;
    }

    public double getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(double previousReading) {
        this.previousReading = previousReading;
    }
}

