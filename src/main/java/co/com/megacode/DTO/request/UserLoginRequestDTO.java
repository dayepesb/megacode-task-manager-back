package co.com.megacode.DTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import static co.com.megacode.constant.JsonPropertiesName.PASSWORD;
import static co.com.megacode.constant.JsonPropertiesName.USERNAME;

public class UserLoginRequestDTO {

    @JsonProperty(value = USERNAME, required = true, access = JsonProperty.Access.READ_WRITE)
    private String username;

    @JsonProperty(value = PASSWORD, required = true, access = JsonProperty.Access.READ_WRITE)
    private String password;

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
}
