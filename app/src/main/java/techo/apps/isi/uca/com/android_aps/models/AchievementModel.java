package techo.apps.isi.uca.com.android_aps.models;

import io.realm.RealmObject;

/**
 * Created by macyarin on 10/4/18.
 */

public class AchievementModel {
    private int id;
    private ExperienceModel experience;
    private String attachmentUri;
    private String description;
    private String date;
    private boolean approved;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExperienceModel getExperience() {
        return experience;
    }

    public void setExperience(ExperienceModel experience) {
        this.experience = experience;
    }

    public String getAttachmentUri() {
        return attachmentUri;
    }

    public void setAttachmentUri(String attachmentUri) {
        this.attachmentUri = attachmentUri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
