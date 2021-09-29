package solar.ampersand.batterySwap.models;

import solar.ampersand.batterySwap.generics.GenericModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "batteries")
public class Battery extends GenericModel {
    @Id
    @Column(name = "battery_id")
    private final UUID batteryId = UUID.randomUUID();
    @Column
    private String name;
    @Column(name = "battery_level")
    private double batteryLevel;

    @OneToOne(mappedBy = "batteryIn")
    private Swap swapIn;
    @OneToOne(mappedBy = "batteryOut")
    private Swap swapOut;

    public UUID getBatteryId() {
        return batteryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Swap getSwapIn() {
        return swapIn;
    }

    public void setSwapIn(Swap swapIn) {
        this.swapIn = swapIn;
    }

    public Swap getSwapOut() {
        return swapOut;
    }

    public void setSwapOut(Swap swapOut) {
        this.swapOut = swapOut;
    }
}
