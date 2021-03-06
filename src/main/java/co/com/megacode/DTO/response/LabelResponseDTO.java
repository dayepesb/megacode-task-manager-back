package co.com.megacode.DTO.response;

import co.com.megacode.constant.JsonPropertiesName;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LabelResponseDTO {

    @JsonProperty(value = JsonPropertiesName.KEY, required = true, access = JsonProperty.Access.READ_ONLY)
    private String key;

    @JsonProperty(value = JsonPropertiesName.LABEL_ES, required = true, access = JsonProperty.Access.READ_ONLY)
    private String labelEs;

    @JsonProperty(value = JsonPropertiesName.LABEL_EN, required = true, access = JsonProperty.Access.READ_ONLY)
    private String labelEn ;

    public LabelResponseDTO(){}

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
