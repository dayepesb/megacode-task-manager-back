package co.com.megacode.DTO.request;

import co.com.megacode.constant.JsonPropertiesName;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserVerifyDTO {

    @JsonProperty(value = JsonPropertiesName.TOKEN, required = true, access = JsonProperty.Access.READ_WRITE)
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
