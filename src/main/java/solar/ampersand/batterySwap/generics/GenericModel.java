package solar.ampersand.batterySwap.generics;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class GenericModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    protected void onCreateAt() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdateAt() {
        updatedAt = new Date();
    }

}
