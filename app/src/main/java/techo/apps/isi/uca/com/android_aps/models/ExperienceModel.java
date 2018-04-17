package techo.apps.isi.uca.com.android_aps.models;

import java.util.ArrayList;

/**
 * Created by macyarin on 2/4/18.
 */

public class ExperienceModel {
    private int id;
    private ArrayList<AchievementModel> achievements = new ArrayList<AchievementModel>();
    private String date;
    private boolean approved;
    private ExperienceTypeModel name;
    private String description;
    private OrganizationModel organization;
    private InterestGroupModel interestGroup;
    private GroupRoleModel groupRole;
    private SETypeModel sEType;
    private SportModel sport;
    private CETypeModel cEType;
    private StudentJobModel studentJob;
    private UniversityModel university;
    private String proyectTitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<AchievementModel> getAchievements() {
        return achievements;
    }

    public void setAchievements(ArrayList<AchievementModel> achievements) {
        this.achievements = achievements;
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

    public ExperienceTypeModel getName() {
        return name;
    }

    public void setName(ExperienceTypeModel name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrganizationModel getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationModel organization) {
        this.organization = organization;
    }

    public InterestGroupModel getInterestGroup() {
        return interestGroup;
    }

    public void setInterestGroup(InterestGroupModel interestGroup) {
        this.interestGroup = interestGroup;
    }

    public GroupRoleModel getGroupRole() {
        return groupRole;
    }

    public void setGroupRole(GroupRoleModel groupRole) {
        this.groupRole = groupRole;
    }

    public SETypeModel getsEType() {
        return sEType;
    }

    public void setsEType(SETypeModel sEType) {
        this.sEType = sEType;
    }

    public SportModel getSport() {
        return sport;
    }

    public void setSport(SportModel sport) {
        this.sport = sport;
    }

    public CETypeModel getcEType() {
        return cEType;
    }

    public void setcEType(CETypeModel cEType) {
        this.cEType = cEType;
    }

    public StudentJobModel getStudentJob() {
        return studentJob;
    }

    public void setStudentJob(StudentJobModel studentJob) {
        this.studentJob = studentJob;
    }

    public UniversityModel getUniversity() {
        return university;
    }

    public void setUniversity(UniversityModel university) {
        this.university = university;
    }

    public String getProyectTitle() {
        return proyectTitle;
    }

    public void setProyectTitle(String proyectTitle) {
        this.proyectTitle = proyectTitle;
    }
}
