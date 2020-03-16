package co.com.megacode.entity;

import javax.persistence.*;

@Entity
@Table(name = "IMAGE")
public class ImageEntity extends BaseEntity {

    @ManyToOne(targetEntity = TypeImageEntity.class, cascade = CascadeType.ALL, optional = false)
    private TypeImageEntity typeImage;

    @ManyToOne(targetEntity = ApplicationEntity.class, cascade = CascadeType.ALL, optional = false)
    private ApplicationEntity application;

    @Column(name = "image_b64", unique = false, nullable = false, length = 1000000)
    private String imageB64;

    @Column(name = "title_imaghe", unique = false, nullable = false)
    private String titleImage;

    @Column(name = "comments_image", unique = false, nullable = false)
    private String commentsImage;


    public TypeImageEntity getTypeImage() {
        return typeImage;
    }

    public void setTypeImage(TypeImageEntity typeImage) {
        this.typeImage = typeImage;
    }

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }

    public String getImageB64() {
        return imageB64;
    }

    public void setImageB64(String imageB64) {
        this.imageB64 = imageB64;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getCommentsImage() {
        return commentsImage;
    }

    public void setCommentsImage(String commentsImage) {
        this.commentsImage = commentsImage;
    }
}
