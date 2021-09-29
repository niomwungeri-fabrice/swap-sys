package solar.ampersand.batterySwap.models;

import solar.ampersand.batterySwap.generics.GenericModel;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "batteries")
public class Battery extends GenericModel {
    @Id
    @Column(name = "battery_id")
    protected UUID batteryId = UUID.randomUUID();
    @Column
    private String name;
    @Column(name = "battery_level")
    private Double batteryLevel;

    @OneToOne(mappedBy = "battery")
    private MotorBikeBattery motorBikeBattery;

    public UUID getBatteryId() {
        return batteryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Double batteryLevel) {
        this.batteryLevel = Objects.requireNonNullElse(batteryLevel, 100.0);
    }

    public MotorBikeBattery getMotorBikeBattery() {
        return motorBikeBattery;
    }

    public void setMotorBikeBattery(MotorBikeBattery motorBikeBattery) {
        this.motorBikeBattery = motorBikeBattery;
    }
}
