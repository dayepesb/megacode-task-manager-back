package co.com.megacode.DTO.response;

import co.com.megacode.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import static co.com.megacode.constant.JsonPropertiesName.*;

public class UserResponseDTO {

    public UserResponseDTO(){
    }
    public UserResponseDTO(UserEntity user, String token){
        this.username = user.getUsername();
        this.image = user.getImage();
        this.token = token;
        this.name = user.getName();
        this.lastname = user.getLastName();
        this.email = user.getEmail();
    }

    @JsonProperty(value = USERNAME, required = true, access = JsonProperty.Access.READ_ONLY)
    private String username;

    @JsonProperty(value = IMAGE, required = true, access = JsonProperty.Access.READ_ONLY)
    private String image;

    @JsonProperty(value = TOKEN, required = true, access = JsonProperty.Access.READ_ONLY)
    private String token;

    @JsonProperty(value = NAME, required = true, access = JsonProperty.Access.READ_ONLY)
    private String name;

    @JsonProperty(value = LAST_NAME, required = true, access = JsonProperty.Access.READ_ONLY)
    private String lastname;

    @JsonProperty(value = EMAIL, required = true, access = JsonProperty.Access.READ_ONLY)
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
