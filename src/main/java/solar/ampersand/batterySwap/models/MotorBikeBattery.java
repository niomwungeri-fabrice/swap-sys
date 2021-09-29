package solar.ampersand.batterySwap.models;


import solar.ampersand.batterySwap.generics.GenericModel;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name="motorbike_batteries")
public class MotorBikeBattery extends GenericModel {
    @Id
    @Column(name = "motorbike_battery_id")
    protected UUID motorBikeBatteryId = UUID.randomUUID();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "motor_bike_id")
    private MotorBike motorBike;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "battery_id")
    private Battery battery;

    public UUID getMotorBikeBatteryId() {
        return motorBikeBatteryId;
    }

    public MotorBike getMotorBike() {
        return motorBike;
    }

    public void setMotorBike(MotorBike motorBike) {
        this.motorBike = motorBike;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }
}
