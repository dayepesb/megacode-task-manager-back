package co.com.megacode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name = "TYPE_IMAGE")
public class TypeImageEntity extends BaseEntity {

    @Column(name = "name_type", unique = true, nullable = false, length = 100)
    private String nameType;

    @Column(name = "comments", length = 80, nullable = true, unique = false)
    private String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
