package co.com.megacode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Column(name = "username", length = 30, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 30, nullable = false, unique = false)
    private String password;

    @Column(name = "md5", length = 255, nullable = false, unique = true)
    private String md5;

    @Column(name = "name", length = 255, nullable = false, unique = false)
    private String name;

    @Column(name = "laastName", length = 255, nullable = false, unique = false)
    private String lastName;

    @Column(name = "numberPhone", length = 255, nullable = false, unique = false)
    private String numberPhone;

    @Column(name = "image", length = 255, nullable = false, unique = true)
    private String image;

    @ManyToOne
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

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
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
}
