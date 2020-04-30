package co.com.megacode.DTO.request;

import co.com.megacode.constant.JsonPropertiesName;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegisterRequestDTO {

    @JsonProperty(value = JsonPropertiesName.NAME, required = true, access = JsonProperty.Access.READ_WRITE)
    private String name;

    @JsonProperty(value = JsonPropertiesName.LAST_NAME, required = true, access = JsonProperty.Access.READ_WRITE)
    private String lastname;

    @JsonProperty(value = JsonPropertiesName.USERNAME, required = true, access = JsonProperty.Access.READ_WRITE)
    private String username;

    @JsonProperty(value = JsonPropertiesName.EMAIL, required = true, access = JsonProperty.Access.READ_WRITE)
    private String email;

    @JsonProperty(value = JsonPropertiesName.PASSWORD, required = true, access = JsonProperty.Access.READ_WRITE)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
