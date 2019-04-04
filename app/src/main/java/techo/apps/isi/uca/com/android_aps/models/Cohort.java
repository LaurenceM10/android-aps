package techo.apps.isi.uca.com.android_aps.models;

import java.util.List;

import androidx.room.Entity;

@Entity
public class Cohort {


    private Carrer carrer;
    private String start_date;
    private String status;

    public Carrer getCarrer() {
        return carrer;
    }

    public void setCarrer(Carrer carrer) {
        this.carrer = carrer;
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
