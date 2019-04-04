package techo.apps.isi.uca.com.android_aps.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Experience {

    @PrimaryKey
    private int id;
    private String name;
    private int personId;

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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
