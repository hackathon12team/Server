package heat.dto;

public class ExtendedUser extends User {
    private String password;

    public ExtendedUser() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
