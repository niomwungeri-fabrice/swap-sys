package solar.ampersand.batterySwap.models;

import solar.ampersand.batterySwap.generics.GenericModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "stations")
public class Station extends GenericModel {
    @Id
    @Column(name = "station_id")
    protected UUID stationId = UUID.randomUUID();
    @Column
    private String location;

    @OneToOne(mappedBy = "station")
    private Swap swap;

    public UUID getStationId() {
        return stationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Swap getSwap() {
        return swap;
    }

    public void setSwap(Swap swap) {
        this.swap = swap;
    }
}
