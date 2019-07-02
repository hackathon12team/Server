package heat.dto;

public class UserDto {

    private int userId;
    private String username;
    private String email;
    private UserSettingsDto userSettings;

    public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserSettingsDto getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(UserSettingsDto userSettings) {
        this.userSettings = userSettings;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
