package techo.apps.isi.uca.com.android_aps.models;

import java.util.ArrayList;

/**
 * Created by macyarin on 10/4/18.
 */

public class OrganizationModel {
    private int id;
    private String name;
    private boolean approved;
    private String description;
    private ArrayList<PersonModel> people;


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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<PersonModel> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<PersonModel> people) {
        this.people = people;
    }
}
