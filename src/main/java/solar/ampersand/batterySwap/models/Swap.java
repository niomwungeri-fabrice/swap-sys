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
    @JoinColumn(name = "battery_in_id")
    private Battery batteryIn;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "battery_out_id")
    private Battery batteryOut;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @Column(name = "battery_level")
    private double batteryLevel;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_id")
    private Station station;

    public UUID getSwapId() {
        return swapId;
    }

    public Battery getBatteryIn() {
        return batteryIn;
    }

    public void setBatteryIn(Battery batteryIn) {
        this.batteryIn = batteryIn;
    }

    public Battery getBatteryOut() {
        return batteryOut;
    }

    public void setBatteryOut(Battery batteryOut) {
        this.batteryOut = batteryOut;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
