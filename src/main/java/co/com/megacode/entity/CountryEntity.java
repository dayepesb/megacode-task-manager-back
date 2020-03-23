package co.com.megacode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class CountryEntity extends BaseEntity {

    @Column(name = "name", length = 50, nullable = false, unique = false)
    private String name;

    @Column(name = "codeCountry", unique = true, length = 5, nullable = false)
    private Integer codeCountry;

    @Column(name = "image", length = 100, nullable = false, unique = false)
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(Integer codeCountry) {
        this.codeCountry = codeCountry;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
