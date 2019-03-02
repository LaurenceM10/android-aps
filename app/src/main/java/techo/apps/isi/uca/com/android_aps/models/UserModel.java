package techo.apps.isi.uca.com.android_aps.models;

/**
 * Created by macyarin on 2/4/18.
 */

public class UserModel {
    private String id;
    private String username;
    private String password;
    private String avatar;

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
