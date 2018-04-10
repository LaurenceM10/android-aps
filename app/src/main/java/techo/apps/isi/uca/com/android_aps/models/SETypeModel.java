package techo.apps.isi.uca.com.android_aps.models;

/**
 * Created by macyarin on 10/4/18.
 */

public class SETypeModel {
    private int id;
    private boolean approved;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
