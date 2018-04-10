package techo.apps.isi.uca.com.android_aps.models;

import java.util.ArrayList;

/**
 * Created by macyarin on 10/4/18.
 */

public class PersonModel {
    protected int id;
    protected String idCardNumber;
    protected String firstName;
    protected String lastName;
    protected String surname;
    protected String lastSurname;
    protected String gender;
    protected ArrayList<PhoneModel> phones;
    protected ArrayList<EmailModel> emailAddresses;
    protected UserModel user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastSurname() {
        return lastSurname;
    }

    public void setLastSurname(String lastSurname) {
        this.lastSurname = lastSurname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<PhoneModel> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<PhoneModel> phones) {
        this.phones = phones;
    }

    public ArrayList<EmailModel> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(ArrayList<EmailModel> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
