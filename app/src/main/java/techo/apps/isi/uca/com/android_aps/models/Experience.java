package techo.apps.isi.uca.com.android_aps.models;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


public class Experience {


    private int id;
    private String name;
    private boolean aproved;
    private int author;
    private List<Field> fields;

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

    public boolean isAproved() {
        return aproved;
    }

    public void setAproved(boolean aproved) {
        this.aproved = aproved;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
