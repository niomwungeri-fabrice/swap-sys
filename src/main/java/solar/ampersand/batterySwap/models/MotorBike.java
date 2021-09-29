package solar.ampersand.batterySwap.models;

import solar.ampersand.batterySwap.generics.GenericModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "motorbikes")
public class MotorBike extends GenericModel {
    @Id
    @Column(name = "motor_bike_id")
    protected UUID motorBikeId = UUID.randomUUID();
    @Column
    private String name;
    @Column
    private String model;

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

}
