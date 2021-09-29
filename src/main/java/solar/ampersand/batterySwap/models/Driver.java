package solar.ampersand.batterySwap.models;

import solar.ampersand.batterySwap.generics.GenericModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "drivers")
public class Driver extends GenericModel {
    @Id
    @Column(name = "user_id")
    private final UUID userId = UUID.randomUUID();
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @Column
    private String names;

    @OneToOne(mappedBy = "driver")
    private Swap swap;

    public UUID getUserId() {
        return userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Swap getSwap() {
        return swap;
    }

    public void setSwap(Swap swap) {
        this.swap = swap;
    }
}
