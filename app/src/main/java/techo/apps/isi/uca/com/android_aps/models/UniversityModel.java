package techo.apps.isi.uca.com.android_aps.models;

/**
 * Created by macyarin on 3/4/18.
 */

public class UniversityModel {
    private String name;
    private boolean isJS; //FIXME: repair this incorrect name
    private boolean approved;
    private CountryModel country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isJS() {
        return isJS;
    }

    public void setJS(boolean JS) {
        isJS = JS;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public CountryModel getCountry() {
        return country;
    }

    public void setCountry(CountryModel country) {
        this.country = country;
    }
}
