package carserviceproject.carservice.models;

import java.io.Serializable;

public class BasicEntity implements Serializable {
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
