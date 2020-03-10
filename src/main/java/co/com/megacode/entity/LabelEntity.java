package co.com.megacode.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LABEL")
public class LabelEntity extends BaseEntity {

    @Column(name="app", nullable = false, unique = true, length = 255)
    private String app;

    @Column(name="code", nullable = false, unique = true, length = 255)
    private String key;

    @Column(name="label_es", nullable = false, unique = true, length = 255)
    private String labelEs;

    @Column(name="label_en", nullable = false, unique = true, length = 255)
    private String labelEn;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabelEs() {
        return labelEs;
    }

    public void setLabelEs(String labelEs) {
        this.labelEs = labelEs;
    }

    public String getLabelEn() {
        return labelEn;
    }

    public void setLabelEn(String labelEn) {
        this.labelEn = labelEn;
    }
}
