package techo.apps.isi.uca.com.android_aps.models;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cohort {

    @PrimaryKey
    private int id;
    private int carrer_id;
    private String start_date;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarrer_id() {
        return carrer_id;
    }

    public void setCarrer_id(int carrer_id) {
        this.carrer_id = carrer_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
