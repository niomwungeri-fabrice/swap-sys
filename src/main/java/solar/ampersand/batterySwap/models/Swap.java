package solar.ampersand.batterySwap.models;

import solar.ampersand.batterySwap.generics.GenericModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "swaps")
public class Swap extends GenericModel {
    @Id
    @Column(name = "swap_id")
    protected UUID swapId = UUID.randomUUID();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taken_battery_id")
    private Battery takenBattery;
    @JoinColumn(name = "returned_battery_id")
    private Battery returnedBattery;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @Column(name = "battery_out_level")
    private Double batteryOutLevel;
    @Column(name = "battery_in_level")
    private Double batteryInLevel;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_id")
    private Station station;

    public UUID getSwapId() {
        return swapId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Battery getTakenBattery() {
        return takenBattery;
    }

    public void setTakenBattery(Battery takenBattery) {
        this.takenBattery = takenBattery;
    }

    public Battery getReturnedBattery() {
        return returnedBattery;
    }

    public void setReturnedBattery(Battery returnedBattery) {
        this.returnedBattery = returnedBattery;
    }

    public double getBatteryOutLevel() {
        return batteryOutLevel;
    }

    public void setBatteryOutLevel(Double batteryOutLevel) {
        this.batteryOutLevel = batteryOutLevel;
    }

    public double getBatteryInLevel() {
        return batteryInLevel;
    }

    public void setBatteryInLevel(Double batteryInLevel) {
        this.batteryInLevel = batteryInLevel;
    }

    @Override
    public String toString() {
        return "Swap{" +
                "takenBattery=" + takenBattery +
                ", returnedBattery=" + returnedBattery +
                ", driver=" + driver +
                ", batteryOutLevel=" + batteryOutLevel +
                ", batteryInLevel=" + batteryInLevel +
                ", station=" + station +
                '}';
    }

}
