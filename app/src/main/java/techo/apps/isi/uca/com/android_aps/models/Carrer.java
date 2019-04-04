package techo.apps.isi.uca.com.android_aps.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Carrer {

    @PrimaryKey
    private int id;
    private String name;
    private int coordinator_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoordinator_id() {
        return coordinator_id;
    }

    public void setCoordinator_id(int coordinator_id) {
        this.coordinator_id = coordinator_id;
    }
}
