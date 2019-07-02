package heat.dto;

public class ExtendedUserDto extends UserDto {

    private String password;

    public ExtendedUserDto() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
