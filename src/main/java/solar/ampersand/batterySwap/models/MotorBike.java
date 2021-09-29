package solar.ampersand.batterySwap.models;

import solar.ampersand.batterySwap.generics.GenericModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "motor_bikes")
public class MotorBike extends GenericModel {
    @Id
    @Column(name = "motor_bike_id")
    private final UUID motorBikeId = UUID.randomUUID();
    @Column
    private String name;
    @Column
    private String model;

    @OneToOne(mappedBy = "motorBike")
    private OdoMeter odoMeter;

    public UUID getMotorBikeId() {
        return motorBikeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public OdoMeter getOdoMeter() {
        return odoMeter;
    }

    public void setOdoMeter(OdoMeter odoMeter) {
        this.odoMeter = odoMeter;
    }

    @Override
    public String toString() {
        return "MotorBike{" +
                "motorBikeId=" + motorBikeId +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", odoMeter=" + odoMeter +
                '}';
    }
}
