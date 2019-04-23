package techo.apps.isi.uca.com.android_aps.models;

import com.google.gson.annotations.SerializedName;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey
    @SerializedName("id")
    private int id;

    @ColumnInfo
    @SerializedName("emails")
    private String emails;

    @ColumnInfo
    @SerializedName("gender")
    private String gender;

    @ColumnInfo
    @SerializedName("idCard")
    private String idCard;

    @ColumnInfo
    @SerializedName("name")
    private String name;

    @ColumnInfo
    @SerializedName("phones")
    private String phones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }
}
