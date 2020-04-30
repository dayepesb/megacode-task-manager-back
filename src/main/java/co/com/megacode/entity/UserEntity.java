package co.com.megacode.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Column(name = "username", length = 150, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 500, nullable = false, unique = false)
    private String password;

    @Column(name = "name", length = 255, nullable = false, unique = false)
    private String name;

    @Column(name = "laastName", length = 255, nullable = false, unique = false)
    private String lastName;

    @Column(name = "numberPhone", length = 255, nullable = true, unique = false)
    private String numberPhone;

    @Column(name = "image", length = 255, nullable = true, unique = true)
    private String image;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private CountryEntity country;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
